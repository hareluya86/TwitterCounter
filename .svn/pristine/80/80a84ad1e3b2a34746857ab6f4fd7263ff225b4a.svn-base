/*
 * ERPEntity
 * 
 * This object is a Data Transfer Object between the Basis layer and Database.
 */
package ERP.Basis.Database;

import java.util.Collection;
import java.util.Map;

/**
 *
 * @author KH
 */
public interface ERPEntity extends DBObject {
    
    /*
     * getPK(): ERPPrimaryKey
     * - Generates the corresponding ERPPrimaryKey object representing the primary
     * key of this DB table
     * - However, ERPPrimaryKey is not a composite object of ERPEntity. Reason:
     *      - 
     */
    public ERPPrimaryKey getPK();
    
    /*
     * randInit()
     * - generates a random object with random values
     * - solely for testing purposes only and not for production use!
     */
    public void randInit(); //for testing purposes only!
    
    
    /*
     * Overrides Object methods
     * - All ERPEntities must override these method for the following purposes
     *      - Sorting and searching in a Collection
     *      - Identifying the same entities in the DB layer
     * 
     * equals(Object anotherERPEntity):boolean
     * - Compares all fields
     * 
     * hashCode():int
     * - Uses all fields 
     * 
     * compareTo():int
     * - Compares all fields
     */
    public boolean equals(Object anotherERPEntity);
    public int hashCode();
    public int compareTo();
    
    /*
     * equalsPK(ERPEntity anotherERPEntity): boolean
     * - Compares only PK fields (Are both the same tuple?)
     */
    public boolean equalsTuple(ERPEntity anotherERPEntity);
    
}
