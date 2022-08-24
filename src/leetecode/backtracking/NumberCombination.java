package leetecode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NumberCombination {

    public static void main(String ...args){
        System.out.println(new NumberCombination().combine(4, 2));
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> combinations = new ArrayList<>();
        combineBacktrack(n, 1, k, combinations, finalList);
        return finalList;
    }

    private void combineBacktrack(int n, int i, int k, List<Integer> combinations, List<List<Integer>> finalList){
            if (combinations.size() == k) {
                finalList.add(new ArrayList<>(combinations));
                return;
            }
        for(int j=i; j<=n; j++){
            combinations.add(j);
            combineBacktrack(n, j+1, k, combinations, finalList);
            combinations.remove(combinations.size()-1);
        }
    }
}
