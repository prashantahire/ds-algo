package leetecode.math;

public class PalindromeNumber {

    public static void main(String ...args){
        System.out.println(new PalindromeNumber().isPalindrome(121));
    }
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int orig = x;
        int rev = 0;
        int rem;
        while (x>0){
            rem = x%10;
            x=x/10;
            if(rev > Integer.MAX_VALUE/10 || (rev==Integer.MAX_VALUE/10 && rem > 7))
                return false;
            rev = rev*10+rem;
        }
        return rev == orig;
    }

    public boolean isPalindromeImprov(int x){
        if(x < 0 ||(x % 10 == 0 && x != 0))
            return false;
        int rev = 0, rem=0;
        while (x > rev){
            rem = x%10;
            x=x/10;
            rev = rev*10+rem;
        }
        return x == rev || x == rev/10;
    }
}
