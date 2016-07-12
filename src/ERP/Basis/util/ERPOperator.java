/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ERP.Basis.util;

/**
 *
 * @author KH
 */
public enum ERPOperator {
    
    //Comparison
    EQ("EQUALS","="),
    LT("LESS","<"),
    LE("LESSEQUALS","<="),
    GT("GREATER",">"),
    GE("GREATEREQUALS",">="),
    
    //Boolean
    AND("AND","&&"),
    OR("OR","||"),
    NOT("NOT","!"),
    XOR("XOR","XOR"),
    
    
    ;//Feel free to add more operators here! It's free and easy!
    
    private String name;
    private String value;
    
    /*
     * numOperands: int
     * - number of permitted operands
     * - should be in another class called "FUNCTION"?
     * 
     */
    private int numOperands;
    
    ERPOperator(String name,String value){
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return getValue();
    }
    
    public String getName(){
        return name;
    }
    
    public String getValue(){
        return value;
    }
    
    
}
