package leetecode.array;

public class MaxSumSubArray {
    
    public static void main(String ...args) {
        MaxSumSubArray ms = new MaxSumSubArray();
        int a[] = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(ms.maxSubArray(a));
    }
    public int maxSubArray(int[] nums) {
        int cs = nums[0];
        int ms = nums[0];
        int i=1;
        while(i<nums.length) {
            cs = Math.max(nums[i], cs+nums[i]);
            if(ms < cs)
                ms = cs;
            i++;
        }
        return ms;
    }
}
