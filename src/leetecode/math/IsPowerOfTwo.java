package leetecode.math;

public class IsPowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        int ans=1;
        for(int i=0; i<31;i++){
            if(ans == n)
                return true;
            ans = ans<<1;
        }
        return false;
    }
}
