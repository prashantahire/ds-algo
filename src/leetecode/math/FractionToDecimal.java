package leetecode.math;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/fraction-to-recurring-decimal/
public class FractionToDecimal {

    public static void main(String ...args){
        FractionToDecimal ftd = new FractionToDecimal();
        System.out.println(ftd.fractionToDecimal(1,2));
        System.out.println(ftd.fractionToDecimal(4,333));
    }
    public String fractionToDecimal(int numerator, int denominator) {

        if(denominator == 0)
            return "";
        if(numerator == 0)
            return "0";
        StringBuilder sb = new StringBuilder();
        if((numerator < 0) ^ (denominator <0)){
            sb.append("-");
        }
        long reminder;
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        sb.append(num/den);
        reminder = num%den;
        if(reminder == 0)
            return sb.toString();
        sb.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(reminder, sb.length());
        while(reminder != 0){
            reminder = reminder*10;
            sb.append(reminder/den);
            reminder = reminder%den;
            if(map.containsKey(reminder)){
                sb.insert(map.get(reminder), "(");
                sb.append(")");
                break;
            }else{
                map.put(reminder, sb.length());
            }
        }
        return sb.toString();
    }
}
