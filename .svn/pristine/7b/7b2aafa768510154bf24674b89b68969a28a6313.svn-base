/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package URLConnector;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 *
 * @author KH
 */
public class JSONObjectWrapper {
    String open;
    String close; 
    
    List<String> jsonObj;
    
    public JSONObjectWrapper(){
        open = "";
        close = "";
        jsonObj = new ArrayList<String>();
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public List<String> getJsonObj() {
        return jsonObj;
    }

    public void setJsonObj(List<String> jsonObj) {
        this.jsonObj = jsonObj;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }
    
    public JSONObject export(){
        //"Flatten" the file
        String flatFile = "";
        for(String fileLine:jsonObj){
            flatFile = flatFile.concat(fileLine);
        }
        
        //Remove the open and close tokens
        StringBuilder sb = new StringBuilder(flatFile);
        if(sb.substring(0, open.length()).equals(open)){
            sb.delete(0, open.length());
        }
        if(sb.substring(sb.length()-close.length(), sb.length()).equals(close)){
            sb.delete(sb.length()-close.length(), sb.length());
        }
        flatFile = sb.toString();
        
        //Convert final string to JSONObject
        return new JSONObject(flatFile);
    }

    @Override
    public String toString() {
        String flatFile = "";
        for(String fileLine:jsonObj){
            flatFile = flatFile.concat(fileLine);
        }
        return flatFile; 
    }
    
    
    
    public static void main(String[] args){
        JSONObjectWrapper wrapper = new JSONObjectWrapper();
        List<String> jsonObj = new ArrayList<String>();
        String s = "[{'id':1},{'id':2},{'id':3}]";
        jsonObj.add(s);
        wrapper.setOpen("[");
        wrapper.setJsonObj(jsonObj);
        wrapper.setClose("]");
        
        JSONTokener tst = new JSONTokener(jsonObj.toString());
        JSONArray tsa = new JSONArray(s);
        System.out.println(tsa.length());
        for(int i=0; i<tsa.length(); i++){
            System.out.println(tsa.getJSONObject(i));
        }
    }
}
