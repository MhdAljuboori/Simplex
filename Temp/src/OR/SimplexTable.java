package OR;

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
    
    int numberOfBasicVariables;
    int numberOfNonBasicVariables;
    
    //constant of objective function variables
    double[] C;
    
    //constant of variables evrey equation
    double[][] A;
    
    //Vector of Basic variables
    double[] Basic;
    
    public SimplexTable(int numberOfBasicVariables,int numberOfNonBasicVariables ,
            double[] C,double[][] A) {
        //Sets
        this.A = A;
        this.C = C;
        this.numberOfBasicVariables = numberOfBasicVariables;
        this.numberOfNonBasicVariables = numberOfNonBasicVariables;
    }
    
    public void updateTable(int outVariable,int inVariable) {
        //if it's the same line a' = a/b
        //else a' = a - ((cb)/d)
    }
}
