

package leetecode.backtracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CombinationSum2 {


    public static void main(String... args) {
        
        CombinationSum2 cs2 = new CombinationSum2();
        int a[] = { 10, 1, 2, 7, 6, 1, 5 };
        // System.out.println(cs2.combinationSum2(a, 8));

        int a1[] = { 4, 4, 2, 1, 4, 2, 2, 1, 3 };
         System.out.println(cs2.combinationSum2(a1, 6));

        int a2[] = { 10, 1, 2, 7, 6, 1, 5 };
        System.out.println(cs2.combinationSum2(a2, 8));
        System.out.println(cs2.combinationSum2Better(a2, 8));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tempAns = new ArrayList<>();
        //Arrays.sort(candidates);
        backtrackSum(0, 0, candidates, ans, tempAns, target);
        return ans;
    }

    private void backtrackSum(int sum, int i, int a[], List<List<Integer>> ans, List<Integer> tempAns, int target) {
        if (sum == target) {
            //System.out.println(tempAns);
            //if (!isDuplicate(ans, tempAns))
                ans.add(new ArrayList<>(tempAns));
            return;
        }
        if (sum > target || i == a.length)
            return;
        tempAns.add(a[i]);
        backtrackSum(sum + a[i], i + 1, a, ans, tempAns, target);
        tempAns.remove(tempAns.size() - 1);
      
        backtrackSum(sum, i + 1, a, ans, tempAns, target);
    }

    public boolean isDuplicate(List<List<Integer>> ans, List<Integer> tempAns) {
        boolean isDup = false;
        HashMap<Integer, Integer> t1 = new HashMap<>();
        for (Integer a : tempAns) {
            if (!t1.containsKey(a))
                t1.put(a, 1);
            else
                t1.put(a, t1.get(a) + 1);
        }
        for (List<Integer> list : ans) {
            if (tempAns.size() == list.size()) {
                isDup = true;
                HashMap<Integer, Integer> t2 = new HashMap<>();
                for (Integer a : list) {
                    if (!t2.containsKey(a))
                        t2.put(a, 1);
                    else
                        t2.put(a, t2.get(a) + 1);
                }
                
                for(Map.Entry<Integer, Integer> entry: t1.entrySet()) {
                    if(!t2.containsKey(entry.getKey()) || !(t2.get(entry.getKey()) == entry.getValue())) {
                        isDup = false;
                        break;
                    }
                }
                if(isDup)
                    return true;
            }
        }
        return isDup;
    }
    
    
    public List<List<Integer>> combinationSum2Better(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();      
        helper(candidates,target, 0, new ArrayList<>(), ans);
        return ans;
        
    }
    public void helper(int[] candidates, int target, int start, List<Integer> list, List<List<Integer>> ans){
        if(target < 0) return;
        if(target ==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = start; i< candidates.length; i++){
            if(i>start && candidates[i] ==candidates[i-1])continue;
            list.add(candidates[i]);
            helper(candidates, target-candidates[i], i+1,list, ans);
            list.remove(list.size()-1);
        }
    }
}
