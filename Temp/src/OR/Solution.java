
package OR;

/**
 *
 *
 */
public class Solution {

    private Double[] variables;
    
    private Integer[] Basic;
    
    /**
     * 
     * @param variables the value of variables
     * @param Basic the basic vector
     */
    public Solution(Double[] variables,Integer[] Basic) {
        this.variables = variables;
        this.Basic = Basic;
    }
    
    public Double getValue(int numberOfVariable) {
        return variables[numberOfVariable];
    }
    
    public Integer getBasicFromIndex(int index) {
        return Basic[index];
    }

    /**
     * @param variables the variables to set
     */
    public void setVariables(Double[] variables) {
        this.variables = variables;
    }

    /**
     * @param Basic the Basic to set
     */
    public void setBasic(Integer[] Basic) {
        this.Basic = Basic;
    }
}
