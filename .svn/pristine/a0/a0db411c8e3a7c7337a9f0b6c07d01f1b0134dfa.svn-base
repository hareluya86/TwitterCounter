/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ERP.Basis.Database;

//import Basis.BRM.ERPCriteria;
import ERP.Basis.util.ResultContainer;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author KH
 */
public abstract class DAO {
    /*
     * ***********************Development Phase*********************************
     * Functional Specifications Document 0.0 Database Module
     * 
     */
    /*
     * Variables required for DAO
     * - Transaction: interface
     */
    protected Map<String,String> DBConfig;
    /*
     * READ METHODS
     */
    /*
     * FSD section 4.1.1
     * Select(Collection<ERPPrimaryKey> pkList): Collection<ERPEntity>
     * Provide a list of unique primary keys belonging to one or more data table
     * and retrieve a list of unique data objects.
     */
    public abstract Collection<ERPEntity> Select(Collection<ERPPrimaryKey> pkList);
    
    /*
     * FSD section 4.1.2
     * Select(Collection<Criteria> cList, String tableName): Collection<ERPEntity>
     * Provide a list of criteria containing fields from 1 table and retrieve a 
     * list of unique data objects fulfilling all the criteria provided.
     */
    //public abstract Collection<ERPEntity> Select(Collection<ERPCriteria> cList, String tableName);
    
    /*
     * FSD section 4.1.3
     * Get(Collection<ERPPrimaryKey> pkList, int lockMode): ResultContainer
     * Provide a list of primary keys belonging to one or more data table, 
     * retrieve a list of unique data objects, and lock them from other users.
     */
    public abstract ResultContainer Get(Collection<ERPPrimaryKey> pkList, int lockMode);
    
    /*
     * FSD section 4.1.4
     * Join(Collection<Criteria> cList, Collection<String> tableNames, Collection<String> columns): Collection<JoinEntity>
     * Provide a list of tables, a list of conditions, a list of columns to show 
     * and retrieve a list of values from the tables fulfilling those criteria. 
     */
    //public abstract Collection<JoinEntity> Join(Collection<ERPCriteria> cList, Collection<String> tableNames, Collection<String> columns);
    
    /*
     * FSD section 4.1.5
     * Pick(String tableName, int start, int limit): Collection<ERPEntity>
     * Provide a tablename, index iand n number of results required and retrieve 
     * n records of the same type.
     */
    public abstract Collection<ERPEntity> Pick(String tableName, int start, int limit);
    
    /*
     * FSD section 4.1.6
     * Count(String tableName, Collection<Criteria> cList): int
     * Provide tablename, a list of criteria and retrieve the number of records 
     * fulfiling all the criteria.
     */
    //public abstract int Count(String tableName,Collection<ERPCriteria> cList);
    
    /*
     * FSD section 4.1.7
     * Lock(ERPEntity entity, boolean lock): ResultContainer
     * Providing a ERPEntity object or its own primary key, the type of lock 
     * required and executes the lock.
     */
    public abstract ResultContainer Lock(ERPEntity entity, boolean lock);
    
    /*
     * FSD section 4.1.8
     * Refresh(ERPEntity entity): ResultContainer
     * Providing a ERPEntity object or its own primary key, the type of lock 
     * required and retrieves a fresh instance of it from the database again. 
     * Type of lock can be specified as null if no locking is required.
     * 
     */
    public abstract ResultContainer Refresh(ERPEntity entity);
    
    /*
     * FSD section 4.1.9
     * Insert(Collection<ERPEntity> entities, boolean commit): ResultContainer
     * Provide a list of ERPEntity to be modified in the database collectively 
     * with or without commit- if any one of them fails, none will be committed. 
     */
    public abstract ResultContainer Insert(Collection<ERPEntity> entities, boolean commit);
    
    /*
     * FSD section 4.1.10
     * Modify(Collection<ERPEntity> entities, boolean commit): ResultContainer
     * Provide a list of ERPEntity to be modified in the database collectively 
     * with or without commit- if any one of them fails, none will be committed. 
     */
    public abstract ResultContainer Modify(Collection<ERPEntity> entities, boolean commit);
    
    /*
     * FSD section 4.1.11
     * Delete(Collection<ERPEntity> entities, boolean commit): ResultContainer
     * Provide a list of ERPEntity to be deleted in the database collectively 
     * with or without commit- if any one of them fails, none will be committed. 
     */
    public abstract ResultContainer Delete(Collection<ERPEntity> entities, boolean commit);
    
    /*
     * FSD section 4.1.12 
     * Commit(): ResultContainer
     * Commit all changes since the last commit to the database.
     */
    public abstract ResultContainer Commit();
    
    /*
     * FSD section 4.1.13
     * Unlock(ERPEntity entity): ResultContainer
     * Unlocks a specific ERPEntity which was previously locked.
     */
    public abstract ResultContainer Unlock();
    
    /*
     * FSD section 4.1.14
     * Rollback(): ResultContainer
     * Rollback all changes made since the last commit to the database.
     */
    public abstract ResultContainer Rollback();

}
