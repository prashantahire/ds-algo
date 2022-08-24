package leetecode.dynaprog;

import java.util.*;

public class DifferentWays2AddParenthesis {

    public static void main(String ...args){
        DifferentWays2AddParenthesis dw = new DifferentWays2AddParenthesis();
        System.out.println(dw.diffWaysToCompute("2-1-1"));
        System.out.println(dw.diffWaysToComputeDP("2-1-1"));
    }

    public List<Integer> diffWaysToCompute(String input) {
        return diffWaysToComputeRec(input);
    }

    private List<Integer> diffWaysToComputeRec(String input) {
        if(input == null || input.length()==0)
            return new ArrayList<>();
        boolean expression = false;
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<input.length(); i++) {
            List<Integer> left;
            List<Integer> right;
            if("+-*".indexOf(input.charAt(i)) != -1){
                left  = diffWaysToComputeRec(input.substring(0, i));
                right  = diffWaysToComputeRec(input.substring(i+1));
                expression = true;
                for(int l : left)
                    for(int r: right)
                        ans.add(compute(l,r,input.charAt(i)));
            }
        }
        if(!expression)
            ans.add(Integer.parseInt(input));
        return ans;
    }

    //Caching/DP top down
    public List<Integer> diffWaysToComputeDP(String input) {
        Map<String, List<Integer>> map = new HashMap<>();
        return diffWaysToComputeDPRec(input, map);
    }

    private List<Integer> diffWaysToComputeDPRec(String input, Map<String, List<Integer>> map) {
        if(input == null || input.length()==0)
            return new ArrayList<>();
        if(map.containsKey(input))
            return map.get(input);
        List<Integer> ans = new ArrayList<>();
        boolean expression = false;
        for(int i=0; i<input.length(); i++) {
            if("+-*".indexOf(input.charAt(i)) != -1){
                List<Integer> left = diffWaysToComputeDPRec(input.substring(0, i), map);
                List<Integer> right = diffWaysToComputeDPRec(input.substring(i+1), map);
                expression=true;
                for(int l: left)
                    for(int r: right)
                        ans.add(compute(l,r,input.charAt(i)));
            }
        }
        if(!expression)
            ans.add(Integer.parseInt(input));
        map.put(input, ans);
        return ans;
    }
    private int compute(int l, int r, char operator){
        int ans=0;
        switch(operator){
            case '+' : ans = l+r;
                       break;
            case '-' : ans = l-r;
                       break;
            case '*' : ans = l*r;
        }
        return ans;
    }
}
