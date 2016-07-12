/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ERP.Basis.Database;

import ERP.Basis.util.ResultContainer;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author KH
 */
public interface DBObject extends Comparable {
    public String name();
    public Collection<String> getFieldNames();
    
    /*
     * Import and Exporting values
     * - All DBObjects should use this method as a replacement to getters and
     * setters. Reason being:
     *      - DBObjects represents DB tables, not an actual objects. We want to
     *        reduce the processing logic within each object as much as possible.
     *      - Maps can be passed through the entire application. DBObjects should 
     *        only exist in the Basis level.
     */
    public void importFromMap(Map<String,Object> attributes);
    public Map<String,Object> exportAsMap();
    
    /*
     * The equals() and hashCode() methods from Object must be implemented in all
     * DBObjects. But the details of the implementation can be different among all 
     * types of DBObjects.
     */
    public boolean equals(Object anotherDBObject);
    public int hashCode();
    public int compareTo();
    
    /*
     * isEqual(DBObject anotherDBObject): boolean
     * - Compares only fields
     * - If there is no requirement to check case sensitive field names,
     * DBObjectComparator.CheckFields can be implemented here. Else, an explicit 
     * checking process should be implemented.
     */
    //public boolean isSame(DBObject anotherDBObject); 
}
