package OR;
import Jama.*;

/**
 *
 * 
 */
public class SimplexTable {
    
//    private int m,n;
//    private double[][] table;
//    
//    public SimplexTable(int n,int m) {
//        this.m = m;
//        this.n = n;
//        table = new double[n][m];
//    }
    
    double[][] items;
    
    int numberOfVariable;
    int numberOfEquation;
    
    private int numberOfBasicVariables;
    private int numberOfNonBasicVariables;
    
    //constant of objective function variables
    private double[] C;
    
    //constant of variables evrey equation
    private double[][] A;
    
    //Vector of Basic variables
    private double[] Basic;
    
    public SimplexTable(int numberOfBasicVariables,int numberOfNonBasicVariables ,
            int numberOfVariables,int numberOfEquation,double[] C,double[][] A) {
        //Sets Value
        this.A = A;
        this.C = C;
        this.numberOfVariable = numberOfVariables;
        this.numberOfEquation = numberOfEquation;
        this.numberOfBasicVariables = numberOfBasicVariables;
        this.numberOfNonBasicVariables = numberOfNonBasicVariables;
    }
    
    
    ///
    /// search variable in basic variables vector 
    /// and return the index of variable
    ///
    /**
     * 
     * @param basicVariable the variable that we want to look for
     * @return the index of variable in basic variable vector
     */
    private int getIndexOfVariable(int basicVariable) {
        for (int i = 0; i < Basic.length; i++) {
            if (Basic[i] == basicVariable) {
                return i;
            }
        }
        return -1;
    }
    
    
    ///
    /// update table after entry variable to basic variables vector
    /// and out variable from basic variables vector
    ///
    /**
     * @param inVariable the variable which will in the basic solution
     *        outVariable the variable which will out the basic solution
     */
    public void updateTable(int outVariable,int inVariable) {
        int indexOfOutVariable = getIndexOfVariable(outVariable);
        //New matrix to set new value in it
        double[][] updatedMatrix = new double[numberOfEquation][numberOfVariable];
        //Entry inVariables instead of outVariable
        Basic[indexOfOutVariable] = inVariable;
        
        //for all items in table
        for (int i = 0; i < numberOfEquation; i++) {
            for (int j = 0; j < numberOfVariable; j++) {
                //if it's the same line a' = a/b
                if (i == indexOfOutVariable) {
//                    updatedMatrix[i][j] = ;
                }
            }
        }
        
        //else a' = a - ((cb)/d)
    }

    /**
     * @return the numberOfBasicVariables
     */
    public int getNumberOfBasicVariables() {
        return numberOfBasicVariables;
    }

    
    public void setNumberOfBasicVariables(int numberOfBasicVariables) {
        this.numberOfBasicVariables = numberOfBasicVariables;
    }
}
