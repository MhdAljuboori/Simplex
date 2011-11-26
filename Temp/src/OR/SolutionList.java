
package OR;

import java.util.LinkedList;

/**
 *
 *
 */
public class SolutionList extends LinkedList<Double[]> {
    private int n;
    
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
     * @param item
     * @return 
     */
    @Override
    public boolean add(Double[] item) {
        if (item.length == n+1) {
            super.add(item);
            return true;
        }
        else{
            throw new RuntimeException("item must be Double[" + (n+1) +"]");
        }
    }
    
}
