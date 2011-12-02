
package OR;


/**
 *
 * 
 */
public class SimplexProblem {
    Matrix A;
    Double[] C;
    Double[] b;
    long time = 0;
    
    
    ProblemType Type;

    public enum ProblemType {
        Max,
        Min
    }
    /**
     * a constructor for internal uses only
     */
    private SimplexProblem() {
        
    }
    
    public SimplexProblem(ProblemType type,double[][] A,Double[] C , Double[] b) {
       // we consider that all conditions are <=  .... simple simplex
       this.Type = type;
       //creating Matrix[m,n+m]; slack for every condition
       int m = A.length;
       int n = A[0].length ;
       Matrix mA = new Matrix(m, n + m);
       // filling Matrix A
       mA.setMatrix(0,m-1,0,n-1, new Matrix(A));
       //extends the matrix by an identity matrix of slacks
       mA.setMatrix(0,m-1,n,n+m-1, Matrix.identity(m, m));
       this.A = mA;
       this.C = new Double[n+m];
       for (int i=0;i<n;i++)
           this.C[i] = C[i];
       for (int i=n;i<n+m;i++)
           this.C[i] = new Double(0);
       this.b = b;
    }
    
    private void setTime(long time) {
        this.time = time;
    }
    
    /**
     * 
     * @return Time of execution
     */
    public long getTime() {
        return time;
    }
    
    /** 
     * method for creating Simplex Problem by Entering the Basic Form
     */
    public static SimplexProblem fromBasicFrom() {
        return new SimplexProblem();
    }
    
    private boolean isMax() {
        return (Type == ProblemType.Max) ? true : false;
    }
    
    public String getLegalFormAsText() {
        String LegalForm = "Legal Form : \n";
        StringBuilder LegalFormBuilder = new StringBuilder(LegalForm);
        // addign Z statement
        LegalFormBuilder.append(Type.toString().toLowerCase()).append("Z=");
        for (int i=0;i<C.length-1;i++)
            LegalFormBuilder.append(C[i]).append(" X").append(i+1).append(" +");
        LegalFormBuilder.append(C[C.length-1]).append(" X").append(C.length).append(" \n");
        
        // adding conditions
        LegalFormBuilder.append("Subjected To : \n");
        
        for (int i = 0; i < A.getRowDimension(); i++) {
            LegalFormBuilder.append("\t");
            for (int j = 0; j < A.getColumnDimension()-1; j++) {
                LegalFormBuilder.append(A.get(i, j)).append(" X").append(j+1).append(" +");
            }
            LegalFormBuilder.append(A.get(i,A.getColumnDimension()-1)).append(" X").append(A.getColumnDimension()).append(" = ");
            LegalFormBuilder.append(b[i].toString()).append("\n");
        }
        LegalForm = LegalFormBuilder.toString();
        return LegalForm;
    }
    /**
     * 
     * @return solution of table we worked on it
     */
    public SolutionList solveByTableSimplex() {
        SimplexTable table = new SimplexTable(A, C ,b ,isMax());
        //set first solution
        SolutionList solution = table.getSolution();
        //Start Time
        long t0 = System.nanoTime();
        //while table not best
        while (!table.isItBestSolution()) {
            //update tabe and set type of solution
            int solutionType = table.updateTable();
            //if it's unlimited
            if (solutionType == -2) {
                solution = table.getSolution();
                //Exit loop
                break;
            }
            //solution is already best
            else if(solutionType == -1) {
                //Exit loop
                break;
            }
            //there is a solution
            else {
            	solution = table.getSolution();
            }
        }
        //if table is best
        if(table.isItBestSolution()) {
            //get number of non basic variables
            int ZeroNonBasicNumber = table.getIndexOfNonBasicVariableZero();
            //for all zeros
            for (int i = 0; i < ZeroNonBasicNumber; i++) {
                //update table and assume that first index of zero inVariable
                table.updateTable(table.getIndexOfNonBasicVariableZero());
                //add solution to solution variable
                solution.add(table.getSolution().get(0));
                //solution type is infinity
                solution.setInfinity();
            }
        }
        //End Time
        long t1 = System.nanoTime();
        setTime(t1-t0);
        //set solution time
        solution.time = getTime();
        //set solution table
        solution.table = table;
        return solution;
    }
}
