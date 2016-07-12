/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TwitterCounter;

import ERP.Basis.Database.ERPEntity;
import ERP.Basis.Database.ERPPrimaryKey;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author KH
 */
public class UserTrendID implements ERPEntity {

    private String USERNAME;
    private java.sql.Date REQUESTDATE;
    private String TRENDID;

    public Date getREQUESTDATE() {
        return REQUESTDATE;
    }

    public void setREQUESTDATE(Date REQUESTDATE) {
        this.REQUESTDATE = REQUESTDATE;
    }

    public String getTRENDID() {
        return TRENDID;
    }

    public void setTRENDID(String TRENDID) {
        this.TRENDID = TRENDID;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }
    
    @Override
    public ERPPrimaryKey getPK() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void randInit() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int compareTo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean equalsTuple(ERPEntity anotherERPEntity) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String name() {
        return "USERTRENDID";
    }

    @Override
    public Collection<String> getFieldNames() {
        ArrayList<String> fields = new ArrayList<String>();
        fields.add("USERNAME");
        fields.add("REQUESTDATE");
        fields.add("TRENDID");
        
        return fields;
    }

    @Override
    public void importFromMap(Map<String, Object> attributes) {
        
        if(attributes.containsKey("REQUESTDATE")){
            Object date = attributes.get("REQUESTDATE");
            //Convert everything to java.sql.date
            java.sql.Date tempDate;
            if(date instanceof Date){
                tempDate = new java.sql.Date(((Date)date).getTime());
            }
            else if(date instanceof java.sql.Date){
                tempDate = (java.sql.Date)date;
            }
            else if(date instanceof Long){
                tempDate = new java.sql.Date((Long)date);
            }
            else{
                //don't set a date if it is an unknown format
                tempDate = null;
                System.out.println("Unknown format for date "+date.getClass().getName());
            }
            this.setREQUESTDATE(tempDate);
        }
        
        if(attributes.containsKey("USERNAME"))
            this.setUSERNAME(attributes.get("USERNAME").toString());
        if(attributes.containsKey("TRENDID"))
            this.setTRENDID(attributes.get("TRENDID").toString());
    }

    @Override
    public Map<String, Object> exportAsMap() {
        Map<String, Object> mapOutput = new HashMap<String,Object>();
        mapOutput.put("REQUESTDATE", this.getREQUESTDATE());
        mapOutput.put("USERNAME", this.getUSERNAME());
        mapOutput.put("TRENDID", this.getTRENDID());
        
        return mapOutput;
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
