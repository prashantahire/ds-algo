

package leetecode.backtracking;


import java.util.ArrayList;
import java.util.List;


public class CombinationSum {

    public static void main(String... args) {
        CombinationSum cs = new CombinationSum();
        int candidates[] = { 2, 3, 5 };
        //System.out.println(cs.combinationSum(candidates, 8));
        
        int a[] = {2, 3, 5};
        System.out.println(cs.combinationSum(a, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> fs = new ArrayList<>();

        for (int i = 0; i < candidates.length; i++) {
            List<Integer> sol = new ArrayList<>();
            sumHelper(candidates, 0, target, sol, fs);
        }
        return fs;
    }

    private void sumHelper(int a[], int i, int ts, List<Integer> solsofar, List<List<Integer>> finalSols) {
        if (i == a.length)
            return;
        int tmp;
        for (int j = 1; j <= ts / a[i]; j++) {
            tmp = ts - (j * a[i]);
            if (tmp == 0) {
                solsofar.add(a[i]);
                finalSols.add(solsofar);
            }
            else if (tmp > 0) {
                solsofar.add(a[i]);
                for(int k=i+1; k<a.length; k++) {
                    List<Integer> s = new ArrayList<>();
                    s.addAll(solsofar);
                    sumHelper(a, k, tmp, s, finalSols);
                    
                }
            }
        }
    }
    
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> rs = new ArrayList<List<Integer>>();
        com(rs,new ArrayList<Integer>(),candidates,target,0,0);
        return rs;
    }
    
    private void com(List<List<Integer>> rs, List<Integer> s, int[] c, int t,int sum,int start){
        if(sum==t){
            List<Integer> ss = new ArrayList<Integer>(s);
            rs.add(ss);
            return;
        }
        if(sum>t) return;
        
        for(int i=start;i<c.length;i++){
            s.add(c[i]);
            com(rs,s,c,t,sum+c[i],i);
            s.remove(s.size()-1);
        }       
    }
}
