/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ERP.Basis.util;

/**
 *
 * @author KH
 */
class RCObject{
    private int id;
    private String module;
    private String objectName;
    private String message;
    private Object object;

    public RCObject(int id, String module, String objectName, String message, Object object) {
        this.id = id;
        this.module = module;
        this.objectName = objectName;
        this.message = message;
        this.object = object;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }
    
    
}
