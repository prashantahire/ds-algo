package leetecode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    
    public static void main(String ...args) {
        Permutations p = new Permutations();
        int a[] = {1,2,3, 4, 5};
        System.out.println(p.permute(a));
        
        StringBuilder sb = new StringBuilder("hello");
        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb.toString());
        
        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb.toString());

        sb.delete(sb.length()-1, sb.length());
        System.out.println(sb.toString());

    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean vis[] = new boolean[nums.length];
        findPermutations(nums, 0, temp, ans, vis);
        System.out.println(ans.size());
        return ans;
    }
    
    public void findPermutations(int a[], int s, List<Integer> perm, List<List<Integer>> ans, boolean vis[]) {
        if(s==a.length) {
            ans.add(new ArrayList<>(perm));
            return;
        }
        for(int i=0; i<a.length; i++) {
            if(vis[i])
                continue;
            perm.add(a[i]);
            vis[i] = true;
            findPermutations(a, s+1, perm, ans, vis);
            perm.remove(perm.size()-1);
            vis[i] = false;
        }
    }
}
