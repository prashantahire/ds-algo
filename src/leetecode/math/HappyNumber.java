package leetecode.math;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//https://leetcode.com/problems/happy-number/submissions/
public class HappyNumber {

    public static void main(String ...args){
        HappyNumber hn = new HappyNumber();
        //System.out.println(hn.isHappy(19));
        System.out.println(hn.isHappy(2));
    }
    public boolean isHappy(int n) {
        int res = n;
        int num;
        Set<Integer> set = new HashSet<>();
        while (true){
            num = 0;
            if(set.contains(res)) return false;
            set.add(res);
            while (res > 0){
                int rem = res%10;
                num+=rem*rem;
                res = res/10;
            }
            if(num == 1)
                return true;
            res = num;
            System.out.println(res);
        }
    }
}
