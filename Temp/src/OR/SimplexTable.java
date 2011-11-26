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
    //double[] b;
    
    //Concat between A and C
    Matrix ACb;
    
    //Vector of Basic variables
    private Integer[] Basic;
    
    // class have basic variable and it's value
    private Solution solution;
    
    public SimplexTable(Matrix A,Double[] C,Double[] b) {
        //Sets Value
        this.A = A;
        this.C = C; 
        
        //Get First Zero in C to Calculate number of Basic variable
        int indexOfFirstZero = getIndexOfFirstZero(C);
        //Set basic variable in basic vector
        setBasicVarialeInVector(Basic,indexOfFirstZero);
        
        //set number of variables in numberOfVariable instance
        this.numberOfVariable = C.length;
        //set number of equation in numberOfEquation instance
        this.numberOfEquation = A.getRowDimension();
        
        //must be -C in Table and Z instance which is it One
        C = getInvertAndAddOne(C);
        
        //Add b to ACb Matrix
        this.ACb.addVectorAsColumn(numberOfVariable+1, 0, numberOfEquation, b);
        //Add C after change to ACb Matrix
        this.ACb.addVectorAsRaw(0, 0, numberOfVariable+1, C);
        
        
        //set new solution in solution variable
        setNewSolution(ACb);
    }
    
    private Double[] getInvertAndAddOne(Double[] C) {
        Double[] NewC = new Double[C.length+2];
        NewC[0] = 1.0;
        for (int i = 0; i < C.length; i++) {
            NewC[i+1] = C[i] * -1;
        }
        NewC[NewC.length-1] = 0.0;
        return NewC;
    }
    
    private void setNewSolution(Matrix ACb) {
        Double[] Newb = new Double[numberOfEquation +1/*of ObjFun*/];
        for (int i = 0; i < numberOfEquation +1/*of ObjFun*/; i++) {
            Newb [i] = ACb.get(i, numberOfVariable +1/*last column*/);
        }
        solution = new Solution(Newb,Basic);
    }
    
    private void setBasicVarialeInVector(Integer[] Basic,int index) {
        Basic = new Integer[C.length - index];
        for (int i=index ; i < C.length ; i++) {
            Basic[i-index] = i+1;
        }
    }
    
    private int getIndexOfFirstZero(Double[] C) {
        for (int i = 0; i < C.length; i++) {
            if (C[i] == 0)
                return i;
        }
        return -1;
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
    
    /*
    private < T > int getIndexOfVariable(T[] vector,T Variable) {
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == Variable) {
                return i;
            }
        }
        return -1;
     }
     */
    
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
                    if (minimum > ACb.get(i,indexOfInVariable)/ACb.get(i, numberOfVariable+1/*last column*/)
                            || firstEnter) {
                        minimum = ACb.get(i,indexOfInVariable)/ACb.get(i, numberOfVariable+1/*last column*/);
                        index = i;
                        firstEnter = false;
                    }
                }
            }
        }
        return index;
    }
    
    public Solution getSolution() {
        return solution;
    }
    
    private <T> boolean find(T[] vector,T value) {
        for (int i = 0; i < vector.length; i++) {
            if (value == vector[i]) {
                return true;
            }
        }
        return false;
    }
    
    public int NumberOfNonBasicVariableZero() {
        int number =0;
        for (int j = 1; j < numberOfVariable+1; j++) {
            if (!find(Basic,j)) {
                if (A.get(0, j) == 0) {
                    number++;
                }
            }
        }
        return number;
    }
    
    ///
    /// update teble to get best solution
    ///
    /**
     * 
     * @return -1 if the solution is best 
     *         -2 if there is unlimited solution
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
            //Entry inVariables instead of outVariable
            Basic[indexOfOutVariable -1/*for ObjFun*/] = indexOfInVariable;
            //Get New Table after update it
            ACb = getNewTable(indexOfOutVariable, indexOfInVariable);
            //Set new solution in solution Class
            setNewSolution(ACb);
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
    private Matrix getNewTable(int indexOfOutVariable,int indexOfInVariable) {
        
        //New matrix to set new value in it
        Matrix updatedMatrix = new Matrix(numberOfEquation +1/*for ObjFun*/ ,
                numberOfVariable +2/*for instance of ObjFun and RHS*/);
        
        //get dependence item
        double a = ACb.get(indexOfOutVariable, indexOfInVariable);
        
        //for all items in table
        for (int i = 0; i < numberOfEquation +1/*for Ojective function*/; i++) {
            for (int j = 0; j < numberOfVariable +2/*for instance of ObjFun and RHS*/; j++) {
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
                            ACb.get(i, indexOfInVariable)/*c*/)/a);
                }
            }
        }
        return updatedMatrix;
    }
}
