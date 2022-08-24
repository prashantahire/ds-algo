package leetecode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GrayCode {

    public static void main(String ...args){
        for(int i=0; i<5; i++){
            System.out.println((i>>0));
        }
//        System.out.println(new GrayCode().grayCode(3));
    }
        public List<Integer> grayCode(int n) {
            ArrayList<Integer> result = new ArrayList<>();
            for(int i = 0; i != 1 << n; i += 1) {
                result.add((i >> 0) ^ (i >> 1));
            }
            return(result);
        }

    private void grayCodeBt(int i, int n, List<Integer> list, int val){
        if( i >= n){
            list.add(val);
            return;
        }
        grayCodeBt(i+1, n, list, val);
        grayCodeBt(i+1, n, list, (val+(int)Math.pow(2, i)));
    }
    //https://leetcode.com/problems/gray-code/discuss/30108/Java-solution-use-a-stack-easy-to-figure-out-simple-and-interesting
    public List<Integer> grayCodeStsck(int n) {
        List<Integer> list = new LinkedList<>();
        Stack<Integer> stack = new Stack<Integer>();
        list.add(0);
        int i = 0;
        while(i < n) {
            int len = list.size();
            int inc = (int)(Math.pow(2, i));
            for(int j=0; j<len; j++) {
                stack.push(list.get(j));
            }
            while(!stack.isEmpty()) {
                list.add(stack.pop() + inc);
            }
            i++;
        }
        return list;

    }


    private List<Integer> res = new ArrayList<Integer>();
    public List<Integer> grayCodeBt(int n) {
        if(n == 0) {
            res.add(0);
            return res;
        }
        int[] bits = new int[n];
        grayCodeHelper(bits, 0);
        return res;
    }

    private void grayCodeHelper(int[] bits, int curVal) {
        if(!res.contains(curVal)) {
            res.add(curVal);
        }

        for(int i = 0; i < bits.length; i++) {
            if(bits[i] == 0) {
                if(res.contains(curVal + (int)Math.pow(2, i))) {
                    continue;
                }
                else {
                    bits[i] = 1;
                    grayCodeHelper(bits, curVal + (int)Math.pow(2, i));
                    break;
                }
            }
            else {
                if(res.contains(curVal - (int)Math.pow(2, i))) {
                    continue;
                }
                else {
                    bits[i] = 0;
                    grayCodeHelper(bits, curVal - (int)Math.pow(2, i));
                    break;
                }
            }
        }
    }
}
