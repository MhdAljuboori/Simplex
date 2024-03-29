package OR;
/**
 *
 * 
 */
public class SimplexTable {
    //Number of variable an equation
    private int numberOfVariable;
    private int numberOfEquation;
    
    // is objective function Max
    private boolean isMax;
    
    //constant of objective function variables
    private Double[] C;
    
    //Concat between A and C
    Matrix ACb;
    
    //Vector of Basic variables
    private Integer[] Basic;
    
    // class have basic variable and it's value
    private SolutionList solution;
    
    
    /**
     * 
     * @param A the instance Matrix of equations
     * @param C the instance Vector of objective function
     * @param b the right side hand
     * @param isMax true if objective function max false if it's min
     */
    public SimplexTable(Matrix A,Double[] C,Double[] b,boolean isMax) {
        //Sets Value
        this.C = C; 
        this.isMax = isMax;
        
        //Get First Zero in C to Calculate number of Basic variable
        int indexOfFirstZero = getIndexOfFirstZero(C);
        //Set basic variable in basic vector
        Basic = getBasicVariableVector(indexOfFirstZero);
        
        //set number of variables in numberOfVariable instance
        this.numberOfVariable = C.length;
        //set number of equation in numberOfEquation instance
        this.numberOfEquation = A.getRowDimension();
        
        //new Matrix have A and C and b
        ACb = new Matrix(A.getArray());
        
        //must be -C in Table and Z instance which is it One
        C = getInvertAndAddOne(C);
        
        //Add firs column of Z
        this.ACb.addVectorAsColumn(0, 0, numberOfEquation-1, getFirstColumn());
        //Add b to ACb Matrix
        this.ACb.addVectorAsColumn(numberOfVariable+1, 0, numberOfEquation-1, b);
        //Add C after change to ACb Matrix
        this.ACb.addVectorAsRaw(0, 0, numberOfVariable+1, C);
        
        //set new solution in solution variable
        setNewSolution();
    }
    
    /**
     * 
     * @return vector of first column of objective function
     */
    private Double[] getFirstColumn() {
    	Double[] helpVector = new Double[numberOfEquation];
    	for (int i = 0; i < helpVector.length; i++) {
			helpVector[i] = 0.0;
		}
    	return helpVector;
    }
    
    /**
     * 
     * @param C the vector which will return invert of it
     * @return invert and add one to first of vector of C vector
     */
    private Double[] getInvertAndAddOne(Double[] C) {
        Double[] NewC = new Double[C.length+2];
        //Set 1 at first of vector the instance of Z
        NewC[0] = 1.0;
        
        //for all item in C copy to newC
        for (int i = 0; i < C.length; i++) {
            NewC[i+1] = C[i] * -1;
        }
        
        //Set 0 at end of vector the value of Z
        NewC[NewC.length-1] = 0.0;
        return NewC;
    }
    
    /**
     * add new solution to parameter we enter it
     * 
     * @param solution variable that we'll add new solution to it
     */
    public void addNewSolution(SolutionList solution) {
        Double[] Newb = new Double[numberOfVariable +1/*of ObjFun*/];
        
        int AI =0;
        //for all b in ACb Matrix
        for (int i = 0; i < numberOfVariable+1/*of ObjFun*/; i++) {
            if(find(Basic, i) || i == 0) {
                Newb[i] = ACb.get(AI, numberOfVariable +1/*last column*/);
                AI++;
            }
            else {
                Newb[i] = 0.0;
            }
        }
        solution.add(Newb);
    }
    
    /**
     * 
     * set new solution to global solution variable
     * and add to it new solution
     * 
     */
    private void setNewSolution() {
        solution = new SolutionList(numberOfVariable +1/*of ObjFun*/);
        addNewSolution(solution);
    }
    
    /**
     * 
     * @retrun Basic vector of basic variable of first
     * mean first basic variable in Basic vector
     * @param index number of first Basic variable in objective function
     */
    private Integer[] getBasicVariableVector(int index) {
        Integer[] newVector = new Integer[C.length - index];
        for (int i=index ; i < C.length ; i++) {
            newVector[i-index] = i+1;
        }
        return newVector;
    }
    
    /**
     * To get number of variables in equations
     * 
     * @param C the vector of objective function
     * @return the first index of first zero
     */
    private int getIndexOfFirstZero(Double[] C) {
        for (int i = 0; i < C.length; i++) {
            if (C[i] == 0)
                return i;
        }
        return -1;
    }
    
    /**
     * 
     * Search value in vector
     * 
     * @param <T> double or integer ...etc.
     * @param vector which we'll search on it
     * @param value which we'll search for it
     * @return true if value was found else return false
     */
    private <T> boolean find(T[] vector,T value) {
        for (int i = 0; i < vector.length; i++) {
            if (value == vector[i]) {
                return true;
            }
        }
        return false;
    }
    
    
    /**
     * 
     * @return true if it is best solution else return false
     */
    public boolean isItBestSolution() {
        //for all value in C
        for (int i = 1; i < numberOfVariable+2; i++) {
            //if the objective function Max
            if (isMax) {
                //if value is smaller than zero
                if (ACb.get(0, i) < 0) {
                    return false;
                }
            }
            //if the objective function Min
            else {
                //if value is larger than zero
                if (ACb.get(0, i) > 0) {
                    return false;
                }
            }
        }
        //if it's best solution
        return true;
    }
    
    /**
     * 
     * @return All Table with Basic variables
     */
    public Matrix getTable() {
        double[] NewBasic = new double[Basic.length];
        for (int i=0 ;i<Basic.length ;i++) {
            NewBasic[i] = Basic[i].doubleValue();
        }
        Matrix NewACb = ACb;
        Matrix fulltable = new Matrix(NewACb.getRowDimension(), NewACb.getColumnDimension()+1);
        fulltable.setMatrix(0, NewACb.getRowDimension()-1, 1, NewACb.getColumnDimension(),NewACb);
        fulltable.setMatrix(1, NewBasic.length,0,0,new Matrix(new double[][] {NewBasic}).transpose());
        return fulltable;
    }
    
    /**
     * 
     * @return index of in variable by looking for it in objective function equation
     */
    private int getIndexOfInVariable() {
        // Muximun in absolute
        double maximum = 0.0;
        
        //Index of in variable
        int index = -1;
        
        // for all instance of objective function variables
        for (int i = 1; i < numberOfVariable +2/*for ObjFun and RHS*/; i++) {
            //if the objective function Max
            if (isMax) {
                //if there is number smaller than last
                if (maximum > ACb.get(0, i)) {
                    maximum = ACb.get(0, i);
                    index = i;
                }
            }
            //if the objective function Min
            else {
                //if there is number larger than last
                if (maximum < ACb.get(0, i)) {
                    maximum = ACb.get(0, i);
                    index = i;
                }
            }
        }
        return index;
    }
    
    /**
     * 
     * @param indexOfInVariable the index of dependence column
     * @return index of out variable
     */
    private int getIndexOfOutVariable(int indexOfInVariable) {
        // Minimum number b_i / y_ik in column that has variable which will enter solution
        double minimum =0.0;
        // To Know that it's first time we calculate right b_i / y_ik
        boolean firstEnter = true;
        //index of variable wich eill out the solution
        int index = -1;
        
        //for all item in column of variable will in solution
        for (int i = 1; i < numberOfEquation +1/*for ObjFun*/; i++) {
            //if y_ik <> 0
            if (ACb.get(i,indexOfInVariable) != 0) {
                // b_i/y_ik
                double helpNumber = ACb.get(i, numberOfVariable+1/*last column*/) / 
                        ACb.get(i,indexOfInVariable);
                //if b_i/y_ik > 0
                if (helpNumber > 0) {
                    //if there is number smaller than last or this is first enter in if statement
                    if (minimum > helpNumber || firstEnter) {
                        minimum = helpNumber;
                        index = i;
                        firstEnter = false;
                    }
                }
            }
        }
        return index;
    }
    
    /**
     * 
     * @return solution of Table for now
     */
    public SolutionList getSolution() {
        return solution;
    }
    
    /**
     * 
     * @return Number of Non basic variable equal to zero in objective function
     */
    public int NumberOfNonBasicVariableZero() {
        int number =0;
        for (int j = 1; j < numberOfVariable+1; j++) {
            // if it isn't basic variable
            if (!find(Basic,j)) {
                //if it's equal to zero in Ojective function (in C)
                if (ACb.get(0, j) == 0) {
                    number++;
                }
            }
        }
        return number;
    }
    
    /**
     * 
     * @return index of first non basic variable equal to zero
     */
    public int getIndexOfNonBasicVariableZero() {
        for (int j = 1; j < numberOfVariable+1; j++) {
            // if it isn't basic variable
            if (!find(Basic,j)) {
                //if it's equal to zero in Ojective function (in C)
                if (ACb.get(0, j) == 0) {
                    return j;
                }
            }
        }
        return -1;
    }
    
    /**
     * update table to get best solution
     * 
     * @return -1 if the solution is best 
     *         -2 if there is unlimited solution
     *          0 Table was updated
     */
    public int updateTable() {
        int indexOfInVariable = getIndexOfInVariable();
        int indexOfOutVariable = getIndexOfOutVariable(indexOfInVariable);
        // if there is not variable to in equation
        if (indexOfInVariable == -1) {
            solution.setBest();
            return -1;
        }
        // if there is not variable to out equation (all items in dependence column Negative or Zero)
        else if (indexOfOutVariable == -1) {
            solution.setUnlimited();
            return -2;
        }
        else {
            //Entry inVariables instead of outVariable
            Basic[indexOfOutVariable -1/*for ObjFun*/] = indexOfInVariable;
            //Get New Table after update it
            ACb = getNewTable(indexOfOutVariable, indexOfInVariable);
            //Set new solution in solution Class
            setNewSolution();
            solution.setOne();
            return 0;
        }
    }
    
    
    /**
     * update table after entry variable to basic variables vector
     * and out variable from basic variables vector
     * 
     * @param indexOfInVariable the index variable which will entry the basic solution
     * @return -2 if there is unlimited solution
     *          0 Table was updated
     */
    public int updateTable(int indexOfInVariable) {
        int indexOfOutVariable = getIndexOfOutVariable(indexOfInVariable);
        if (indexOfOutVariable == -1) {
            solution.setUnlimited();
            return -2;
        }
        else {
            //Entry inVariables instead of outVariable
            Basic[indexOfOutVariable -1/*for ObjFun*/] = indexOfInVariable;
            //Get New Table after update it
            ACb = getNewTable(indexOfOutVariable, indexOfInVariable);
            //Set new solution in solution Class
            setNewSolution();
            solution.setOne();
            return 0;
        }
    }
    
    /**
     * update table after entry variable to basic variables vector
     * and out variable from basic variables vector
     * 
     * @param indexOfInVariable the variable which will entry the basic solution
     *        indexOfOutVariable the variable which will out the basic solution
     */
    private Matrix getNewTable(int indexOfOutVariable,int indexOfInVariable) {
        
        //New matrix to set new value in it
        Matrix updatedMatrix = new Matrix(numberOfEquation +1/*for ObjFun*/ ,
                numberOfVariable +2/*for instance of ObjFun and RHS*/);
        
        //set first instance of Z
        updatedMatrix.set(0, 0, 1);
        
        //get dependence item
        double a = ACb.get(indexOfOutVariable, indexOfInVariable);
        
        //for all items in table
        for (int i = 0; i < numberOfEquation +1/*for Ojective function*/; i++) {
            for (int j = 1/*we don't want Z column*/; 
                    j < numberOfVariable +2/*for instance of ObjFun and RHS*/; j++) {
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
