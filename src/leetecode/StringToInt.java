

package leetecode;


public class StringToInt {
    
    public static void main(String ...args) {
        StringToInt s2i = new StringToInt();
        System.out.println(s2i.myAtoi("    -42  23"));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE/10);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE/10);
    }
    public int myAtoi(String str) {
        boolean digfound = false;
        boolean signFound = false;
        int sign=1;
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            if (!digfound && !signFound && str.charAt(i) == ' ')
                continue;

            if (!digfound && !signFound && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
                signFound = true;
                if(str.charAt(i) == '-')
                    sign = -1;
                continue;
            }
            if (str.charAt(i) >= '0' && str.charAt(i) <='9') {
                if(sign ==1 && (sum > Integer.MAX_VALUE/10 || (sum == Integer.MAX_VALUE/10 && str.charAt(i)-'0'>7))) {
                    return  (sign == -1) ? Integer.MIN_VALUE: Integer.MAX_VALUE;
                }
                sum = sum*10 + (str.charAt(i)-'0');
                digfound = true;
            }
            else {
                break;
            }
        }
        return sum*sign;
    }
}
