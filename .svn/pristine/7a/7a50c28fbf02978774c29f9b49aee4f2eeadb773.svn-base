/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package URLConnector;

import java.net.*;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;


public class URLConnectionReader {

    public static void main(String[] args) throws Exception {
        /*URL oracle = new URL("https://api.twitter.com/1/users/lookup.json?screen_name=vwgstore&include_entities=true");
        URLConnection yc = oracle.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(
                yc.getInputStream()));
        String inputLine;
        ArrayList<String> jsonObjString = new ArrayList<String>();
         
        while ((inputLine = in.readLine()) != null) {
            jsonObjString.add(inputLine);
        }
        in.close();
        
        JSONObjectWrapper jsonObjWrapper = new JSONObjectWrapper();
        jsonObjWrapper.setJsonObj(jsonObjString);
        jsonObjWrapper.setOpen("[");
        jsonObjWrapper.setClose("]");
        JSONObject jsonObj = jsonObjWrapper.export();
        
        int followers = jsonObj.getInt("followers_count");
        System.out.println(followers);*/
        System.out.println("Working Directory = " +
              System.getProperty("user.dir"));
    }

    private String url;
    
    public URLConnectionReader(String url) {
        this.url = url;
    }

    public URLConnectionReader() {
        this("");
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public List<String> read(){
        ArrayList<String> fileObject = new ArrayList<String>();
        try{
            URL urlObject = new URL(url);
            URLConnection yc = urlObject.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                fileObject.add(inputLine);
            }
            in.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            fileObject.clear(); //return empty file if hit exception
        }
        return fileObject;
    }
    
    public String readAsString(){
        List<String> results = this.read();
        String result = "";
        for(String line:results){
            result += line;
        }
        return result;
    }
}
