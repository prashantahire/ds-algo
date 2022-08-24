package leetecode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation2 {
    
    public static void main(String ...args) {
        Permutation2 p = new Permutation2();
        int a[] = {1, 1, 2};
        //System.out.println(p.permuteUnique(a));
        
        int a1[] = {3,3,0,3};
        System.out.println(p.permuteUnique(a1));
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> pool = new ArrayList<>();
        List<Integer> tempAns = new ArrayList<>();
        Arrays.sort(nums);
        for(int i:nums) {
            pool.add(i);
        }

        dfs(tempAns, pool, ans);
        return ans;
        
    }
    
    private void dfs(List<Integer> tempAns, List<Integer> pool, List<List<Integer>> ans) {
        if(pool.size() == 0)
        {
            ans.add(new ArrayList<>(tempAns));
            return;
        }
        List<Integer> poolTemp = new ArrayList<>(pool); 
        for(int i=0; i<poolTemp.size(); i++) {
            if(i>0 && poolTemp.get(i-1) == poolTemp.get(i)) continue;
            
            int num = poolTemp.get(i);
            tempAns.add(num);
            poolTemp.remove(i);
            
            dfs(tempAns, poolTemp, ans);
            
            poolTemp.add(i, num);
            tempAns.remove(tempAns.size()-1);
        }
    }

    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean vis[] = new boolean[nums.length];
        //to skip dups
        Arrays.sort(nums);
        puBt(0,vis,nums,list,ans);
        return ans;
    }

    private void puBt(int i, boolean[] vis, int a[], List<Integer> list, List<List<Integer>> ans){
        if(i>=a.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int j=0; j<a.length; j++){

            if(j>0 && a[j]==a[j-1]) continue;
            if(vis[j]) continue;
            vis[j] = true;
            list.add(a[j]);
            puBt(i+1, vis, a, list, ans);
            vis[j] = false;
            list.remove(list.size()-1);
        }
    }
}
