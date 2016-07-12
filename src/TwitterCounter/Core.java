/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TwitterCounter;

import ERP.Basis.Database.ERPEntity;
import ERP.Basis.Database.ERPEntityFactory;
import ERP.Basis.util.ERPFileReader;
import ERP.Basis.util.ERPFileWriter;
import URLConnector.URLConnectionReader;
import java.util.*;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author KH
 */
public class Core {
    
    public static void main(String[] args){
        List<ERPEntity> compList = new ArrayList<ERPEntity>();
        List<ERPEntity> compLookupList = new ArrayList<ERPEntity>();
        
        String inputFile = "companies.csv";
        if(args.length >0)
            inputFile = args[0];
        ERPFileReader reader = new ERPFileReader(inputFile,System.getProperty("user.dir"));
        List<String> file = reader.readAsLines();
        
        //Retrieve the first line of the file, which is the header
        List<String> headerFieldOrder = new ArrayList<String>();
        String[] header = file.get(0).split(",");
        for(String headerField:header){
            headerFieldOrder.add(headerField);
        }
        //Remove the header
        file.remove(0);
        
        for(String line:file){
            String[] recordDetail = line.split(",");
            ERPEntity newComp = ERPEntityFactory.getERPEntity("COMPANY");
            List<String> fields = new ArrayList<String>(newComp.getFieldNames());
            
            //follow the order of fields stated in the header
            //ignore rest of fields which is not stated in the header
            int recordFieldPtr = 0;
            Map<String,Object> companyObj = new HashMap<String,Object>();
            for(String headerField:headerFieldOrder){
                companyObj.put(headerField, recordDetail[recordFieldPtr++]);
            }
            newComp.importFromMap(companyObj);
            compList.add(newComp);
        }
        //For each company, send a request to twitter to get number of followers
        //Provide a batch limit of companies per request
        int batchLimit = 100;
        int compInReq = 0;
        String baseUrl = "https://api.twitter.com/1/users/lookup.json?screen_name=";
        String url = ""+baseUrl;
        DateTime sysDate = new DateTime(new Date());//System run date, not date of response generated!
        
        for (int i=0;i<compList.size();i++) {
            ERPEntity comp = compList.get(i);
            if (compInReq > 0) {
                url += ",";
            }
            url += comp.exportAsMap().get("USERNAME");
            compInReq++;

            if (compInReq >= batchLimit || i >= (compList.size()-1)) {
                System.out.println(url);//do required action here
                //Get http response string
                URLConnectionReader urlReader = new URLConnectionReader(url);
                String response = urlReader.readAsString();
                
                //The users/lookup api call returns a JSON array
                JSONArray jsa;
                try{
                    jsa = new JSONArray(response);
                }
                catch(Exception e){
                    e.printStackTrace();
                    System.out.println(response);
                    jsa = new JSONArray();
                }
                
                
                for(int j=0; j<jsa.length(); j++){
                    JSONObject jso = jsa.getJSONObject(j);
                    ERPEntity compLookup = ERPEntityFactory.getERPEntity("USERLOOKUPDETAIL");
                    
                    //Pre-define the fields to be obtained from JSONObject
                    Map<String,Object> values = new HashMap<String,Object>();
                    try{
                        values.put("USERNAME", jso.getString("screen_name"));
                        values.put("RECORDDATE", new java.sql.Date(sysDate.getMillis())); //Date of response generated
                        //A little date processing
                        String createdDate = jso.getString("created_at");
                        createdDate = createdDate.substring(4, 11)+createdDate.substring(createdDate.length()-4, createdDate.length());
                        DateTimeFormatter formatter = DateTimeFormat.forPattern("MMM dd YYYY");
                        DateTime jodaDate = formatter.parseDateTime(createdDate);
                        values.put("CREATEDATE", new java.sql.Date(jodaDate.getMillis()));
                        values.put("FOLLOWERCOUNT", jso.getInt("followers_count"));
                        values.put("FRIENDCOUNT", jso.getInt("friends_count"));
                        values.put("ISVERIFIED", jso.getBoolean("verified"));
                        values.put("STATUSESCOUNT",jso.getInt("statuses_count"));
                        values.put("DESCRIPTION", jso.getString("description"));
                        values.put("STATUS", jso.getJSONObject("status").getString("text"));
                    }
                    catch(JSONException jsone){
                        System.out.println("No key found for "+jsone.getMessage()+" in "+jso.toString());
                    }
                    compLookup.importFromMap(values);
                    compLookupList.add(compLookup);
                }
                
                url = "" + baseUrl;
                compInReq = 0;
            }
        }
        
        
        //Retrieve the top 10 trend list
        String trendURL = "https://api.twitter.com/1/trends/1.json"; 
        URLConnectionReader urlReader = new URLConnectionReader(trendURL);
        String response = urlReader.readAsString();
        
        JSONArray trendArray = new JSONArray(response);
        JSONArray trends = trendArray.getJSONObject(0).getJSONArray("trends");
        
        //Put them into a list
        List<ERPEntity> trendLookupList = new ArrayList<ERPEntity>();
        List<String> trendList = new ArrayList<String>(); //Temp list for easy lookup
        for(int i=0;i<trends.length();i++){
            JSONObject trendJSON = trends.getJSONObject(i);
            ERPEntity trendEntity = ERPEntityFactory.getERPEntity("TRENDLOOKUPDETAIL");
            
            Map<String,Object> values = new HashMap<String,Object>();
            
            values.put("TRENDID", trendJSON.getString("name"));
            values.put("TRENDPOSITION", i);
            values.put("TRENDDATE", new java.sql.Date(sysDate.getMillis()));
            
            trendEntity.importFromMap(values);
            trendLookupList.add(trendEntity);
            trendList.add(trendJSON.getString("name"));
            //System.out.println(trendJSON.get("name"));
        }
        //Check through every user status for the top 10 trend and hashtags
        //and store them in ERPEntity lists
        List<ERPEntity> trendIDList = new ArrayList<ERPEntity>();
        List<ERPEntity> hashTagList = new ArrayList<ERPEntity>();
        
        for(ERPEntity companyLookup:compLookupList){
            //Map<String,Object> compLookupValues = companyLookup.exportAsMap();
            UserLookupDetail compLookup = (UserLookupDetail)companyLookup;
            
            String companyName = compLookup.getUSERNAME();
            String status;
            if(compLookup.getSTATUS() != null && compLookup.getSTATUS().length()>0){
                status = compLookup.getSTATUS();
            }
            else{
                status = "";
            }
            
            //Loop through the top 10 trend list
            for(String trend:trendList){
                if(status.contains(trend)){
                    UserTrendID trendID = (UserTrendID)ERPEntityFactory.getERPEntity("USERTRENDID");
                    trendID.setTRENDID(trend);
                    trendID.setUSERNAME(companyName);
                    trendID.setREQUESTDATE(new java.sql.Date(sysDate.getMillis()));
                    
                    trendIDList.add(trendID);
                }
                
            }
            //Check through every user status for Hashtags
            String[] words = status.split("[ `~!@$%^*()-=\\[\\]{};:'\",<.>/?|]");
            for (String word : words) {
                if(word.length()>1 && word.charAt(0) == '#'){
                    //System.out.println(word);
                    UserHashTag userHashTag = (UserHashTag)ERPEntityFactory.getERPEntity("USERHASHTAG");
                    userHashTag.setHASHTAG(word);
                    userHashTag.setUSERNAME(companyName);
                    userHashTag.setREQUESTDATE(new java.sql.Date(sysDate.getMillis()));
                    
                    hashTagList.add(userHashTag);
                }
            }
        }
        
        //Generate CSV file from compLookupList
        ERPFileWriter fileWriter = new ERPFileWriter(System.getProperty("user.dir")+"\\result"+sysDate.toString("yyyyMMddHHmmss")+".csv");
        fileWriter.writeERPEntitiesCSV(compLookupList, "USERLOOKUPDETAIL", true, '|');
        
        fileWriter = new ERPFileWriter(System.getProperty("user.dir")+"\\TrendResult"+sysDate.toString("yyyyMMddHHmmss")+".csv");
        fileWriter.writeERPEntitiesCSV(trendLookupList, "TRENDLOOKUPDETAIL", true, '|');
        
        fileWriter = new ERPFileWriter(System.getProperty("user.dir")+"\\UserTrendID"+sysDate.toString("yyyyMMddHHmmss")+".csv");
        fileWriter.writeERPEntitiesCSV(trendIDList, "USERTRENDID", true, '|');
        
        fileWriter = new ERPFileWriter(System.getProperty("user.dir")+"\\UserHashTag"+sysDate.toString("yyyyMMddHHmmss")+".csv");
        fileWriter.writeERPEntitiesCSV(hashTagList, "USERHASHTAG", true, '|');
        
    }
}
