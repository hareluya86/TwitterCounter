/*
 * ResultContainer
 */
package ERP.Basis.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;



/**
 *
 * @author vivianlee
 */
public class ResultContainer {
    
    private RC_FLAG flag;
    
    private ArrayList<RCObject> retList;
    private ArrayList<RCObject> warnList;
    private ArrayList<RCObject> errList;
    
    public ResultContainer(){
        retList = new ArrayList<RCObject>();
        warnList = new ArrayList<RCObject>();
        errList = new ArrayList<RCObject>();
        flag = RC_FLAG.INITIAL;
    }
    
    public void addRet(int id, String module, String objectName, String message, Object object){
        RCObject rco = new RCObject(id, module, objectName, message, object);
        retList.add(rco);
        updateFlag();
    }
    
    public void addWarn(int id, String module, String objectName, String message, Object object){
        RCObject rco = new RCObject(id, module, objectName, message, object);
        warnList.add(rco);
        updateFlag();
    }
    
    public void addErr(int id, String module, String objectName, String message, Object object){
        RCObject rco = new RCObject(id, module, objectName, message, object);
        errList.add(rco);
        updateFlag();
    }
    
    public boolean hasResults(){
        return retList.size() >0;
    }
    
    public boolean hasWarnings(){
        return warnList.size() >0;
    }
    
    public boolean hasErrors(){
        return errList.size() >0;
    }
    
    private void updateFlag(){
        if(hasErrors()){
            flag = RC_FLAG.ERROR;
        }
        else if(!hasErrors() && hasWarnings()){
            flag = RC_FLAG.WARNING;
        }
        else if(!hasErrors() && !hasWarnings() && hasResults()){
            flag = RC_FLAG.SUCCESS;
        }
        else{
            flag = RC_FLAG.INITIAL;
        }
    }

    public RC_FLAG getFlag() {
        return flag;
    }
    
}
enum RC_FLAG {
    INITIAL(1),
    SUCCESS(2),
    WARNING(3),
    ERROR(4);
    
    private int code;
    
    RC_FLAG(int code){
        this.code = code; //Initial state
    }
    
    public int code(){
        return code;
    }
}