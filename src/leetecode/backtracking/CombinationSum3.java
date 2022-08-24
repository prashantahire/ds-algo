package leetecode.backtracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum-iii/
public class CombinationSum3 {

    public static void main(String ...args){
        CombinationSum3 cs = new CombinationSum3();
        System.out.println(cs.combinationSum3(3, 9));
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSum3Rec(1, 0, k,n,0,list,ans);
        return ans;
    }

    public void combinationSum3Rec(int i, int j, int k, int n, int sum, List<Integer> list, List<List<Integer>> ans){
        if( j >= k){
            if(sum == n){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        for(int l=i; l<=9; l++){
            list.add(l);
            combinationSum3Rec(l+1, j+1, k, n, sum+l, list, ans);
            list.remove(list.size()-1);
        }
    }
}
