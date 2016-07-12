/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TwitterCounter;

import ERP.Basis.Database.ERPEntity;
import ERP.Basis.Database.ERPPrimaryKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author KH
 */
public class Company implements ERPEntity{
    private String USERNAME;
    private int SN;

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public int getSN() {
        return SN;
    }

    public void setSN(int SN) {
        this.SN = SN;
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<String> getFieldNames() {
        ArrayList<String> fields = new ArrayList<String>();
        fields.add("USERNAME");
        fields.add("SN");
        
        return fields;
    }

    @Override
    public void importFromMap(Map<String, Object> attributes) {
        if(attributes.containsKey("USERNAME"))
            this.setUSERNAME((String)attributes.get("USERNAME"));
        if(attributes.containsKey("SN"))
            this.setSN(Integer.parseInt(attributes.get("SN").toString()));
    }

    @Override
    public Map<String, Object> exportAsMap() {
        Map<String, Object> mapOutput = new HashMap<String,Object>();
        mapOutput.put("USERNAME", this.getUSERNAME());
        mapOutput.put("SN", this.getSN());
        
        return mapOutput;
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}

class CompanyId implements ERPPrimaryKey{

    @Override
    public boolean isGenerated() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String name() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Collection<String> getFieldNames() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void importFromMap(Map<String, Object> attributes) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Map<String, Object> exportAsMap() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int compareTo() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
