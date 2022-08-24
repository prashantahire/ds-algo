package sunny;

public class SumOfAsciiValsAtPrime {
    
    public static void main(String ...args) {
        SumOfAsciiValsAtPrime soa = new SumOfAsciiValsAtPrime();
        System.out.println(soa.sumOfAscii("prashant"));
    }
    public int sumOfAscii(String s) {
        int sum = 0;
        for(int i=0; i<s.length();i++) {
            if(isPrime(i))
                sum+=s.charAt(i);
        }
        return sum;
    }
    private boolean isPrime(int n) {
        if(n<=1)
            return false;
        for(int i=2; i<n;i++) {
            if(n%i == 0)
                return false;
        }
        return true;
    }
}
