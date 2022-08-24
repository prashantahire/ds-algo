package leetecode.math;

//https://leetcode.com/problems/factorial-trailing-zeroes/
public class FactorialTrailingZeros {
    public int trailingZeroes(int n) {

        int fiveCnt = 0;
        while (n> 0){
            n/=5;
            fiveCnt+=n;
        }
        return fiveCnt;
    }
}
