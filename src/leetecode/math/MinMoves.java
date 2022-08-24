package leetecode.math;

// 0/10
//https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
public class MinMoves {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int n: nums)
            min = Math.min(min, n);

        int res=0;
        for(int n: nums)
            res+=n-min;
        return res;
    }
}
