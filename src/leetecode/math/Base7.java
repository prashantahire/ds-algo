package leetecode.math;

public class Base7 {
    // TIme O(n)
    // Space: constant
    public String convertToBase7(int num) {
        boolean isNeg = false;
        if(num==0)
            return "0";
        if(num < 0){
            num = -num;
            isNeg= true;
        }
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            sb.append(num%7);
            num = num/7;
        }
        sb.reverse();
        if(isNeg){
            sb.insert(0, '-');
        }
        return sb.toString();
    }
}
