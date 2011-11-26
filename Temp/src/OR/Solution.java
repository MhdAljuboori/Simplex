
package OR;

import java.util.Hashtable;

/**
 *
 *
 */
public class Solution {

    private Double[] variables;
    
    public Solution(Double[] variables) {
        this.variables = variables;
    }
    
    public Double getValue(int numberOfVariable) {
        return variables[numberOfVariable];
    }
}
