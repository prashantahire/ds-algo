package leetecode.math;

public class ReverseInteger {
    public int reverse(int x) {
        int ans = 0;
        int rem;
        while (x!=0){
            rem = x%10;
            x = x/10;
            if (ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE / 10 && ans > 7)) return 0;
            if (ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE / 10 && ans < -8)) return 0;
            ans = ans*10+rem;
        }
        return ans;
    }
}
