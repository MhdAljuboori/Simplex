
package OR;

/**
 *
 * 
 */
public class Condition {
    //is the Condition Large or Less
    private boolean isLarge; 
    
    //The Number of Variables in Condition
    private int numberOfVariable;
    
    //Constant of every variables
    private double[] constant;
    
    //Second side of Condition
    private double secondSide;
    
    //The Equation of Condition
    private Equation equation;
    
    public void Condition(String condition) {
        //TODO Parsing condition and put it in the variables
    }
    
    private void addSurplus() {
        //Add surplus variables
    }
    
    private void addSlack() {
        //Add slack variables
    }
    
    private void addR() {
        
    }
    
    public void toEquation() {
        if (isLarge) {
            //Add surplus variable
            addSurplus();
        }
        else {
            //Add slack variable
            addSlack();
            //Add R
            addR();
        }
        equation = new Equation(constant,numberOfVariable);
    }
}
