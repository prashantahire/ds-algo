package leetecode.binarysearch;

public class Pow {
    
    public static void main(String ...args) {
        Pow p = new Pow();
        System.out.println(p.myPow(2, 10));
        System.out.println(p.myPow(2.1, 3));
        System.out.println(p.myPow(2, -2));
        System.out.println(p.myPow(0.00001,
                    2147483647));
    }
    public double myPow(double x, int n) {
        if(n == 0)
            return 1;
        if(n<0) {
            return myPowRec(1/x, Math.abs(n));
        }
        return myPowRec(x, n);
    }
    public double myPowRec(double x, int n) {
        double ans;
        if(n==0)
            return 1;
        if(n ==1)
            return x;
        ans = myPowRec(x, n/2);
        if(n%2 == 0) {
            return ans*ans;
        }
        else {
            return x*ans*ans;
        }
    }
}
