package leetecode.string;

public class StringMultiply {
    
    public static void main(String ...args) {
        StringMultiply sm = new StringMultiply();
        System.out.println(sm.multiply( "45", "123"));
        System.out.println(sm.multiply( "4234345457675885", "3456567567879"));
    }
    public String multiply(String num1, String num2) {
        int m=num1.length();
        int n=num2.length();
        int ans[] = new int[m+n];
        int sum = 0;
        for(int i=m-1; i>=0; i--) {
            for(int j=n-1; j>=0; j--) {
                int p2 = i+j+1;
                int p1 = i+j;
                sum = ans[p2] + ((num1.charAt(i)-'0') * (num2.charAt(j)-'0'));
                ans[p1] = ans[p1]+sum/10;
                ans[p2] = sum%10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int p : ans) {
            if(p==0 && sb.length()==0) continue;
            else
                sb.append(p);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
