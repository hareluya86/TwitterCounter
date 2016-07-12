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
public class UserLookupDetail implements ERPEntity{

    private String USERNAME; //username
    private java.sql.Date RECORDDATE;
    
    private java.sql.Date CREATEDATE;
    private int LISTEDCOUNT;
    private int FOLLOWERCOUNT;
    private int FRIENDCOUNT;
    private boolean VERIFIED;
    private int STATUSESCOUNT;
    private String DESCRIPTION;
    
    private String STATUS;
    
    //Preferably separate entities
    //private ArrayList<String> TRENDIDS;
    //private ArrayList<String> HASHTAGS;

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public int getFOLLOWERCOUNT() {
        return FOLLOWERCOUNT;
    }

    public void setFOLLOWERCOUNT(int FOLLOWERCOUNT) {
        this.FOLLOWERCOUNT = FOLLOWERCOUNT;
    }

    public Date getRECORDDATE() {
        return RECORDDATE;
    }

    public void setRECORDDATE(Date RECORDDATE) {
        this.RECORDDATE = RECORDDATE;
    }

    public Date getCREATEDATE() {
        return CREATEDATE;
    }

    public void setCREATEDATE(Date CREATEDATE) {
        this.CREATEDATE = CREATEDATE;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public int getFRIENDCOUNT() {
        return FRIENDCOUNT;
    }

    public void setFRIENDCOUNT(int FRIENDCOUNT) {
        this.FRIENDCOUNT = FRIENDCOUNT;
    }

    public boolean isVERIFIED() {
        return VERIFIED;
    }

    public void setVERIFIED(boolean VERIFIED) {
        this.VERIFIED = VERIFIED;
    }

    public int getLISTEDCOUNT() {
        return LISTEDCOUNT;
    }

    public void setLISTEDCOUNT(int LISTEDCOUNT) {
        this.LISTEDCOUNT = LISTEDCOUNT;
    }

    public int getSTATUSESCOUNT() {
        return STATUSESCOUNT;
    }

    public void setSTATUSESCOUNT(int STATUSESCOUNT) {
        this.STATUSESCOUNT = STATUSESCOUNT;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }
/*
    public ArrayList<String> getHASHTAGS() {
        return HASHTAGS;
    }

    public void setHASHTAGS(ArrayList<String> HASHTAGS) {
        this.HASHTAGS = HASHTAGS;
    }

    public ArrayList<String> getTRENDIDS() {
        return TRENDIDS;
    }

    public void setTRENDIDS(ArrayList<String> TRENDIDS) {
        this.TRENDIDS = TRENDIDS;
    }
    * 
    */
    
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
        return "COMPANYLOOKUPDETAIL";
    }

    @Override
    public Collection<String> getFieldNames() {
        ArrayList<String> fields = new ArrayList<String>();
        fields.add("USERNAME");
        fields.add("RECORDDATE");
        fields.add("FOLLOWERCOUNT");
        fields.add("CREATEDATE");
        fields.add("LISTEDCOUNT");
        fields.add("FRIENDCOUNT");
        fields.add("VERIFIED");
        fields.add("STATUSESCOUNT");
        fields.add("DESCRIPTION");
        
        fields.add("STATUS");
        
        return fields;
    }

    @Override
    public void importFromMap(Map<String, Object> attributes) {
        if(attributes.containsKey("USERNAME"))
            this.setUSERNAME((String)attributes.get("USERNAME"));
        if(attributes.containsKey("RECORDDATE")){
            Object date = attributes.get("RECORDDATE");
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
            this.setRECORDDATE(tempDate);
        }
        if(attributes.containsKey("CREATEDATE")){
            Object date = attributes.get("CREATEDATE");
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
                tempDate = null;
                //don't set a date if it is an unknown format
                System.out.println("Unknown format for date "+date.getClass().getName());
            }
            this.setCREATEDATE(tempDate);
        }
        if(attributes.containsKey("FOLLOWERCOUNT"))
            this.setFOLLOWERCOUNT((Integer)attributes.get("FOLLOWERCOUNT"));
        if(attributes.containsKey("LISTEDCOUNT"))
            this.setLISTEDCOUNT((Integer)attributes.get("LISTEDCOUNT"));
        if(attributes.containsKey("FRIENDCOUNT"))
            this.setFRIENDCOUNT((Integer)attributes.get("FRIENDCOUNT"));
        if(attributes.containsKey("VERIFIED"))
            this.setVERIFIED((Boolean)attributes.get("VERIFIED"));
        if(attributes.containsKey("STATUSESCOUNT"))
            this.setSTATUSESCOUNT((Integer)attributes.get("STATUSESCOUNT"));
        if(attributes.containsKey("DESCRIPTION"))
            this.setDESCRIPTION(attributes.get("DESCRIPTION").toString());
        if(attributes.containsKey("STATUS"))
            this.setSTATUS(attributes.get("STATUS").toString());
        /*if(attributes.containsKey("TRENDIDS"))
            this.setTRENDIDS((ArrayList)attributes.get("TRENDIDS"));
        if(attributes.containsKey("HASHTAGS"))
            this.setHASHTAGS((ArrayList)attributes.get("HASHTAGS"));
            * 
            */
            
    }

    @Override
    public Map<String, Object> exportAsMap() {
        Map<String, Object> mapOutput = new HashMap<String,Object>();
        mapOutput.put("USERNAME", this.getUSERNAME());
        mapOutput.put("RECORDDATE", this.getRECORDDATE());
        mapOutput.put("FOLLOWERCOUNT", this.getFOLLOWERCOUNT());
        mapOutput.put("CREATEDATE", this.getCREATEDATE());
        mapOutput.put("LISTEDCOUNT", this.getLISTEDCOUNT());
        mapOutput.put("FRIENDCOUNT", this.getFRIENDCOUNT());
        mapOutput.put("VERIFIED", this.isVERIFIED());
        mapOutput.put("STATUSESCOUNT", this.getSTATUSESCOUNT());
        mapOutput.put("DESCRIPTION", this.getDESCRIPTION());
        mapOutput.put("STATUS", this.getSTATUS());
        /*mapOutput.put("TRENDIDS", this.getTRENDIDS());
        mapOutput.put("HASHTAGS", this.getHASHTAGS());
        * 
        */
        
        return mapOutput;
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
