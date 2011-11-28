
package OR;

import java.util.LinkedList;

/**
 *
 *
 */
public class SolutionList extends LinkedList<Double[]> {
    private int n;
    private SolutionType Type = SolutionType.OneOptimalSolution;
    private enum SolutionType {
        OneOptimalSolution,Unlimited,InfinityOfOptimalSolutions,Best
    }
    
    public SimplexTable table;
    public long time ;
    /**
     *  creates a new solution for n variables
     * @param n number of variables
     */
    public SolutionList(int n) {
        super();
        this.n = n;
    }
    
    /**
     * adds a new Solution to the SolutionList
     * warning : you must add a solution with length = n + 1
     * @param item the solution to Add
     * @return true upon insertion
     * @throws RuntimeException when not adding Double[n+1]
     */
    @Override
    public boolean add(Double[] item) {
        if (item.length == n) {
            super.add(item);
            return true;
        }
        else{
            throw new RuntimeException("item must be Double[" + (n) +"]");
        }
    }
    
    /**
     * gets the number of variables (n) in this solution
     * @return 
     */
    public int getVariablesCount() {
        return n-1;
    }
    /**
     * gets the full length (with z)
     * @return 
     */
    public int getLength() {
        return n;
    }
    
    public void setBest() {
        Type = SolutionType.Best;
    }
    
    public void setOne() {
        Type = SolutionType.OneOptimalSolution;
    }
    
    public void setUnlimited() {
        Type = SolutionType.Unlimited;
    }
    
    public void setInfinity() {
        Type = SolutionType.InfinityOfOptimalSolutions;
    }
    
    /**
     * gets the type if the solution
     * @return one , unlimited or Infinity of optimal Solutions
     */
    public SolutionType getType() {
        return this.Type;
    }
}
