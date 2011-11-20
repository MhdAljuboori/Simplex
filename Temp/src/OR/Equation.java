
package OR;

/**
 *
 * 
 */
public class Equation {
    //The Number of variables in Equation
    private int numberOfVariable;
    
    //Constant of every variables
    private double[] constant;

    public Equation(double[] constant, int numberOfVariable) {
        this.constant = constant;
        this.numberOfVariable = numberOfVariable;
    }
}
