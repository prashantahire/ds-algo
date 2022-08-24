package leetecode.binarysearch;

import java.util.Map;

public class DivivdeTwoInts {

    int gdivident;
    int res;

    //Recursive
    public int divide(int dividend, int divisor) {

        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if(divisor==1)
            return dividend;
        boolean isNeg = (dividend < 0 && divisor > 0) || (dividend>0 && divisor<0);

        this.gdivident = Math.abs(dividend);
        this.res = 0;
        binaerySearch(Math.abs(divisor), 1);
        return isNeg ? -this.res : this.res;
    }

    private void binaerySearch(int divisor, int multipleOfDivisor){
        if(gdivident > divisor){
            binaerySearch(divisor+divisor, multipleOfDivisor+multipleOfDivisor);
        }
        if(gdivident >= divisor){
            this.gdivident-=divisor;
            this.res+=multipleOfDivisor;
        }
    }

    public int divideIter(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        if(divisor==1)
            return dividend;
        boolean isNeg = (dividend < 0 && divisor > 0) || (dividend>0 && divisor<0);
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int res = 0;
        while (dividend-divisor >= 0){

            int step = 1;
            int cur = divisor;
            while (dividend-(cur+cur) > 0){
                step+=step;
                cur+=cur;
            }
            res = res+step;
            dividend = dividend-cur;
        }
        return isNeg ? -res : res;
    }
}
