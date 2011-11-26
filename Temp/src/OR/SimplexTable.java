package OR;

/**
 *
 * 
 */
public class SimplexTable {
    
    private int numberOfVariable;
    private int numberOfEquation;
    
    // is objective function Max
    private boolean isMax;
    
    //constant of variables evrey equation
    private Matrix A;
    
    //constant of objective function variables
    private Double[] C;
    
    //RHS of Table
    double[] b;
    
    //Concat between A and C
    Matrix ACb;
    
    //Vector of Basic variables
    private Integer[] Basic;
    
    // class have basic variable and it's value
    private Solution solution;
    
    public SimplexTable(Matrix A,Double[] C,double[] b) {
        //Sets Value
        this.A = A;
        this.C = C; //must be -C and RHS of C Zero
        //this.ACb = //Concat A and C and b;
        // and set zeros in first column
        
        //set number of variables in numberOfVariable instance
        //set number of equation in numberOfEquation instance
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
    
    private < T > int getIndexOfVariable(T[] vector,T Variable) {
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == Variable) {
                return i;
            }
        }
        return -1;
     }
    
    /**
     * 
     * @return true if it is best solution else return false
     */
    public boolean isItBestSolution() {
        for (int i = 0; i < C.length; i++) {
            if (isMax) {
                if (C[i] < 0) {
                    return false;
                }
            }
            else {
                if (C[i] > 0) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private int getIndexOfInVariable() {
        // Muximun in absolute
        double maximum = 0.0;
        
        //Index of in variable
        int index = -1;
        
        // for all instance of objective function variables
        for (int i = 0; i < numberOfVariable +2/*for ObjFun and RHS*/; i++) {
            if (isMax) {
                if (maximum > ACb.get(0, i)) {
                    maximum = C[i];
                    index = i;
                }
            }
            else {
                if (maximum < C[i]) {
                    maximum = C[i];
                    index = i;
                }
            }
        }
        return index;
    }

    private int getIndexOfOutVariable(int indexOfInVariable) {
        // Minimum number b_i / y_ik in column that has variable which will enter solution
        double minimum =0.0;
        // To Know that it's first time we calculate right b_i / y_ik
        boolean firstEnter = true;
        //index of variable wich eill out the solution
        int index = -1;
        
        //for all item in column of variable will in solution
        for (int i = 1; i < numberOfEquation +1/*for ObjFun*/; i++) {
            if (ACb.get(i,indexOfInVariable) != 0) {
                double helpNumber = ACb.get(i, numberOfVariable+1/*last column*/) / 
                        ACb.get(i,indexOfInVariable);
                if (helpNumber > 0) {
                    if (minimum > ACb.get(i,indexOfInVariable)/b[i] || firstEnter) {
                        minimum = ACb.get(i,indexOfInVariable)/b[i];
                        index = i;
                        firstEnter = false;
                    }
                }
            }
        }
        return index;
    }
    
    public Integer[] getBasicVariables() {
        return Basic;
    }
    
    public Solution getSolution() {
        return solution;
    }
    
    public boolean isThereNonBasicVariableZero() {
        for (int j = 0; j < numberOfVariable; j++) {
            if (j != Basic[j]) {
                if (A.get(1, j) == 0) {
                    return true;
                }
            }
        }
        return false;
    }
    
    ///
    /// update teble to get best solution
    ///
    /**
     * 
     * @return -1 if the solution is best 
     *         -2 if there is unknown solution
     *          0 Table was updated
     */
    public int updateTable() {
        int indexOfInVariable = getIndexOfInVariable();
        int indexOfOutVariable = getIndexOfOutVariable(indexOfInVariable);
        if (indexOfInVariable == -1) {
            return -1; 
        }
        else if (indexOfOutVariable == -1) {
            return -2;
        }
        else {
            ACb = getNewTable(indexOfOutVariable, indexOfInVariable);
            return 0;
        }
    }
    
    ///
    /// update table after entry variable to basic variables vector
    /// and out variable from basic variables vector
    ///
    /**
     * @param inVariable the variable which will in the basic solution
     *        outVariable the variable which will out the basic solution
     */
    private Matrix getNewTable(int outVariable,int inVariable) {
        
        int indexOfOutVariable = getIndexOfVariable(Basic,outVariable);
        
        //New matrix to set new value in it
        Matrix updatedMatrix = new Matrix(numberOfEquation,numberOfVariable);
        
        //Entry inVariables instead of outVariable
        Basic[indexOfOutVariable] = inVariable;
        
        //get dependence item
        double a = ACb.get(indexOfOutVariable, inVariable);
        
        //for all items in table
        for (int i = 0; i < numberOfEquation +1/*for Ojective function*/; i++) {
            for (int j = 0; j < numberOfVariable; j++) {
                if (i == indexOfOutVariable) {
                    //if it's the same line a' = b/a
                    // b: item we want to update it
                    // a: dependence item
                    updatedMatrix.set(i, j, ACb.get(i, j)/*b*//a);
                }
                else {
                    //else a' = d - ((cb)/a)
                    // d: item we want to update it
                    // b: the intersection between 'd' column and 'a' Line
                    // c: the intersection between 'd' Line and 'a' column
                    // d: dependence point
                    updatedMatrix.set(i, j, ACb.get(i, j)/*d*/ - (ACb.get(indexOfOutVariable, j)/*b*/ *
                            ACb.get(i, inVariable)/*c*/)/a);
                }
            }
        }
        return updatedMatrix;
    }
}
