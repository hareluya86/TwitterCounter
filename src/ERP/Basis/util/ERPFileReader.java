/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ERP.Basis.util;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author KH
 */
public class ERPFileReader {
    private String file;
    private String path;
    private Charset ENCODING;

    public ERPFileReader(String file) {
        this(file,"");
    }
    public ERPFileReader(String file, String path) {
        this(file,path,StandardCharsets.UTF_8); //default if not given
    }
    
    public ERPFileReader(String file, String path, Charset encoding){
        this.file = file;
        this.path = path;
        this.ENCODING = encoding;
    }
    
    /*
     * Returns a single line string of entire content
     */
    public String readAsString(){
        List<String> lines = readAsLines();
        String finalLine = "";
        for(String line:lines){
            finalLine += line;
        }
        return finalLine;
    }
    
    /*
     * Returns a List of lines of strings
     */
    public List<String> readAsLines(){
        Path finalPath = FileSystems.getDefault().getPath(this.path, this.file);
        List<String> result;
        try{
            result = Files.readAllLines(finalPath, ENCODING);
        }
        catch(IOException ioe){
            ioe.printStackTrace();
            result = new ArrayList<String>();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            result = new ArrayList<String>();
        }
        finally{
            //Just in case
        }
        return result;
    }
}
