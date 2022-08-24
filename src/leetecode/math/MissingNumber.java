package leetecode.math;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length==0)
            return 0;
        int sum = ((nums.length)*(nums.length+1))/2;
        for(int n : nums)
            sum-=n;
        return sum;
    }
}
