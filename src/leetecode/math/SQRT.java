package leetecode.math;

public class SQRT {

    public int mySqrt(int x) {
        if(x==0 || x==1)
            return x;
        int i=1, j=x;
        while (i<=j){
            int m = (i+j)/2;
            //check sqrt is m or it lies betwn m and m+1
            if(m <= x/m && (m+1)>x/(m+1))
                return m;
            else if(m<x/m)
                i=m+1;
            else
                j=m-1;
        }
        return i;
    }
}
