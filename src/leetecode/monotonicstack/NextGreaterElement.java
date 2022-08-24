package leetecode.monotonicstack;
import java.util.*;
public class NextGreaterElement {
//[1,2,5,3,4,8,3,6]
//
//        1 2 2 2
//        2 2 2
//
//
//    a=2

    public int[] nextGreaterElements(int[] nums) {


        Stack<int[]> stack = new Stack<>();
        int ans[] = new int[nums.length];
        for(int i=0; i<nums.length; i++) {

            while(!stack.isEmpty() && stack.peek()[0]<nums[i]){

                int temp[] = stack.pop();
                ans[temp[1]] = nums[i];
            }
            stack.push(new int[]{nums[i], i});
        }
        int first = stack.firstElement()[0];
        while(!stack.isEmpty()){
            int temp[] = stack.pop();
            if(first > temp[0]){
                ans[temp[1]] = first;
            } else
                ans[temp[1]] = -1;
        }
        return ans;
    }

    // [1,2,3,2,1]
    // st: 3 2
    // ans: 2 3
//----------------
//    : 6,5,4,2,1,3
//    st: 6
//
//            -1 6 6 3 3 6
}
