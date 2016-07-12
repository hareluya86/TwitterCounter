/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ERP.Basis.util;

import ERP.Basis.Database.ERPEntity;
import ERP.Basis.Database.ERPEntityFactory;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.*;

/**
 *
 * @author KH
 */
public class ERPFileWriter {
    private String file;
    private String path;
    private Charset ENCODING;
    
    public ERPFileWriter(String file) {
        this(file,"");
    }
    public ERPFileWriter(String file, String path) {
        this(file,path,StandardCharsets.UTF_8); //default if not given
    }
    
    public ERPFileWriter(String file, String path, Charset encoding){
        this.file = file;
        this.path = path;
        this.ENCODING = encoding;
    }
    
    public ResultContainer writeERPEntitiesCSV(List<ERPEntity> entities, String entityName, boolean headers, char delimiter){
        ResultContainer rc = new ResultContainer();
        if(!ERPEntityFactory.checkEntityValid(entityName)){
            rc.addErr(-1, "ERPFileWriter", entityName, "No such entity exists!", entityName);
            return rc;
        }
        Path finalPath = FileSystems.getDefault().getPath(this.path, this.file);
        try{
            ERPEntity e = ERPEntityFactory.getERPEntity(entityName);
            
            FileWriter writer = new FileWriter(finalPath.toString());
            List<String> fieldList = new ArrayList<String>(e.getFieldNames());
            
            if(headers){
                boolean first = true;
                for(String field:fieldList){
                    if(first){
                        first = false;
                    }
                    else{
                        writer.append(delimiter);
                    }
                    writer.append(field);
                }
                writer.append("\r\n");
            }
            //start writing main content
            for(ERPEntity entity:entities){
                Map<String,Object> values = entity.exportAsMap();
                String line = ""; //"Row" to be written into 
                boolean first = true;
                for(String field:fieldList){
                    if(first){
                        first = false;
                    }
                    else{
                        line += delimiter;
                    }
                    
                    String lineValue = ""+values.get(field); //to remove \r\n
                    line += lineValue.replaceAll("[\n\r]", " ");
                    //line += values.get(field);
                }
                writer.append(line);
                writer.append("\r\n");
            }
            writer.flush();
            writer.close();
            
            rc.addRet(0, "ERPFileWriter", entityName, "CSV file generated", null);
        }
        catch(IOException ioe){
            rc.addErr(-1, "ERPFileWriter", "Path", ioe.getMessage(), finalPath);
            System.out.println("Something wrong here IOException "+ioe.getLocalizedMessage());
        }
        catch(NullPointerException npe){
            //most commonly thrown nullpointerexception will be from ERPEntityFactory
            rc.addErr(-1, "ERPFileWriter", "ERPEntity", npe.getMessage(), entityName);
            System.out.println("Something wrong here NullPointerException");
            npe.printStackTrace(System.out);
        }
        
        catch(Exception e){
            rc.addErr(-1, "ERPFileWriter", entityName, e.getMessage(), e);
            System.out.println(e.getLocalizedMessage());
        }
        return rc;
    }
    
    public static void main(String[] args){
        /*ERPFileWriter writer = new ERPFileWriter("D:/Projects/twittercounter/src/java/ERP/Basis/util/test.csv");
        List<ERPEntity> entities = new ArrayList<ERPEntity>();
        for(int i=0;i<100;i++){
            ERPEntity company = ERPEntityFactory.getERPEntity("COMPANY");
            Map<String,Object> values = new HashMap<String,Object>();
            values.put("USERNAME", Integer.toString(i));
            values.put("SN", i);
            company.importFromMap(values);
            entities.add(company);
        }
        
        writer.writeERPEntitiesCSV(entities, "COMPANY", true,'|');
        * 
        */
        String line = "We are the official Twitter news handle for Bank of America Corporation. Providing relevant, up to date information on the company.\r\nFor important disclosures:";
        line = line.replaceAll("[\n\r]", " ");
        System.out.println(line);
    }
}
