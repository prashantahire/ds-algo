package leetecode.graph.dfs;

//https://leetcode.com/problems/circular-array-loop/submissions/
// 1/10 -> 
public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        boolean  vis[] = new boolean[nums.length];
        boolean   rec[] = new boolean[nums.length];
        for(int i=0; i<nums.length; i++) {
            if(!vis[i] && isCycle(nums, i, vis, rec)) {
                return true;
            }

        }
        return false;
    }



    private boolean isCycle(int nums[], int start, boolean vis[], boolean rec[]) {

        if(rec[start])
            return true;
        if(vis[start])
            return false;
        int next = nums[start] + start;
        next = next%nums.length + nums.length;
        next = next % nums.length;
        if(next == start || nums[start]*nums[next] < 0) {
            return false;
        }
        rec[start] = true;
        boolean cyc = isCycle(nums, next, vis, rec);
        rec[start] = false;
        return cyc;
    }
}
