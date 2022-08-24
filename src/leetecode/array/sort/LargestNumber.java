package leetecode.array.sort;

import java.util.ArrayList;
import java.util.List;

public class LargestNumber {

    public static void main(String ...args){
        int a[] = {3,30,34,5,9};
        LargestNumber ln = new LargestNumber();
        System.out.println(ln.largestNumber(a));
    }
    public String largestNumber(int[] nums) {
        List<String> numsList = new ArrayList<>();
        for(int num : nums){
            numsList.add(""+num);
        }
        numsList.sort((s1, s2) -> {
           String o1 = s1+s2;
           String o2 = s2+s1;
           return o2.compareTo(o1);
        });
        if(numsList.get(0).equals("0"))
            return "0";
        final StringBuilder sb = new StringBuilder();
        numsList.forEach(s -> {
            sb.append(s);
        });
        return sb.toString();
    }
}
