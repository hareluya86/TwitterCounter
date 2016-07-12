/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ERP.Basis.Database;

import TwitterCounter.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author KH
 */
public class ERPEntityFactory {
    
    //Temporary placed here
    public static int CLIENT = 181;;
    
    private static Map<String,ERPEntity> entities;
    
    public static void init(){
        entities = new HashMap<String,ERPEntity>();
        entities.put("COMPANY", new Company());
        entities.put("USERLOOKUPDETAIL", new UserLookupDetail());
        entities.put("TRENDLOOKUPDETAIL", new TrendLookupDetail());
        entities.put("USERHASHTAG", new UserHashTag());
        entities.put("USERTRENDID", new UserTrendID());
        
    }
    
    public static ERPEntity getERPEntity(String ERPEntityName){
        init();
        ERPEntityName = ERPEntityName.toUpperCase();
        if(!entities.containsKey(ERPEntityName))
            return null;
        return entities.get(ERPEntityName);
        
    }
    
    public static ERPPrimaryKey getERPPK(String ERPEntityName){
        ERPEntity entity = getERPEntity(ERPEntityName);
        if(entity==null) return null;
        return entity.getPK();
    }
    
    public static Collection<ERPEntity> getAllEntities(){
        init();
        return entities.values();
    }
    
    public static Collection<String> getAllEntityNames(){
        init();
        return entities.keySet();
    }
    
    public static boolean checkEntityValid(String entityName){
        entityName = entityName.toUpperCase();
        return entities.containsKey(entityName);
    }
}
