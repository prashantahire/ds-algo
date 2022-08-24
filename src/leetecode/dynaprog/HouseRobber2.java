package leetecode.dynaprog;

import java.util.Arrays;

//https://leetcode.com/problems/house-robber-ii/
public class HouseRobber2 {

    public static void main(String ...args){
        int a[]={1,2,3,1};
        int a1[]={1,2};
        HouseRobber2 hr = new HouseRobber2();
        System.out.println(hr.rob(a));
        System.out.println(hr.rob(a1));
    }

    //Backtracking
    public int robBT(int[] nums) {
        if(nums == null || nums.length<=2)
            return 0;
        return Math.max(robBckTracking(0, nums.length-2, nums), robBckTracking(1, nums.length-1, nums));
    }
    public int robBckTracking(int low, int i, int[] a){
        if(i < low)
            return 0;
        return Math.max(a[i] + robBckTracking(low, i-2, a), robBckTracking(low, i-1, a));
    }

    //DP Bottom up (Recursive)
    public int robDPBU(int[] nums) {
        if(nums == null)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int res1[] = new int[nums.length];
        Arrays.fill(res1, -1);
        robDpBottomUp(0, nums.length-2, nums, res1);
        int a1 = res1[nums.length-2];

        Arrays.fill(res1, -1);
        robDpBottomUp(1, nums.length-1, nums, res1);
        return Math.max(a1, res1[nums.length-2]);
    }
    private int robDpBottomUp(int low, int i, int a[], int res[]){
        if(i<low)
            return 0;
        if(res[i] != -1)
            return res[i];
        int maxLoot = Math.max((a[i] + robDpBottomUp(low, i-2, a, res)), robDpBottomUp(low, i-1, a, res));
        res[i] = maxLoot;
        return maxLoot;
    }

    //DP Top down (Iterative)
    public int robTD(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int res[] = new int[nums.length+1];
        res[0] = 0;
        res[1] = nums[0];
        for(int i=1; i<nums.length-1; i++){
            int maxLoot = Math.max(res[i-1] + nums[i], res[i]);
            res[i+1] = maxLoot;
        }
        int a1 = res[nums.length-1];

        Arrays.fill(res, 0);
        res[0] = 0;
        res[1] = 0;
        res[2] = nums[1];
        for(int i=2; i<nums.length; i++){
            int maxLoot = Math.max(res[i-1]+nums[i], res[i]);
            res[i+1] = maxLoot;
        }
        return Math.max(a1, res[nums.length]);
    }

    //Final time- O(n) space O(1)
    public int rob(int[] nums) {

        int maxPrev = 0;
        int maxPrevPrev = 0;
        for(int i=0; i<nums.length-1; i++){
            int temp = Math.max(nums[i]+maxPrevPrev, maxPrev);
            maxPrevPrev = maxPrev;
            maxPrev = temp;
        }
        int maxPrev1 = 0;
        int maxPrevPrev1 = 0;
        for(int i=1; i<nums.length; i++){
            int temp = Math.max(maxPrevPrev1+nums[i], maxPrev1);
            maxPrevPrev1 = maxPrev1;
            maxPrev1 = temp;
        }
        return Math.max(maxPrev, maxPrev1);
    }
}
