package leetecode.array;

//https://leetcode.com/problems/minimum-size-subarray-sum/submissions/
public class MinSizeSubArraySum {

    public static void main(String ...args){
        MinSizeSubArraySum ma = new MinSizeSubArraySum();
        int a[]={2,3,1,2,4,3};
        System.out.println(ma.minSubArrayLen(7, a));
    }
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int minCount = Integer.MAX_VALUE;
        int i=0;
        int j=0;
        int sum = 0;
        while(j<nums.length){
            sum+=nums[j];
            j++;
            while (sum >= s) {
                minCount = Math.min(minCount, j - i);
                sum -= nums[i];
                i++;
            }
        }
        return minCount == Integer.MAX_VALUE || minCount < 0 ? 0 : minCount;
    }
}
