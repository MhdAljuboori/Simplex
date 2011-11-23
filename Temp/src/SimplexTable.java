/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mhd
 */
public class SimplexTable {
    private int m,n;
    private double[][] table;
    
    public SimplexTable(int n,int m) {
        this.m = m;
        this.n = n;
        table = new double[n][m];
    }
}
