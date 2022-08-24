package leetecode.stack;

import java.util.*;

public class Pattern132 {
    public boolean find132pattern(int[] nums) {
        TreeSet<int[]> set = new TreeSet<>((a1, a2) -> a1[0]-a2[0]);
        for(int i=0; i<nums.length; i++) {
            int rec[] = new int[]{nums[i], i};
            if(set.size() > 1) {
                int ceil[] = set.ceiling(rec);
                int floor[] = set.floor(rec);
                if(ceil != null && floor != null && floor[1] < i && ceil[1]<i ) {
                    return true;
                }
            }
            set.add(rec);
        }
        return false;
    }

    public boolean find132pattern2(int[] nums) {

        Stack<int[]> stack = new Stack<>();

        int min = nums[0];
        for(int i=1; i<nums.length; i++) {
            while(!stack.isEmpty() && nums[i] >= stack.peek()[0]) {
                stack.pop();
            }
            if(!stack.isEmpty() && nums[i] > stack.peek()[1]) {
                return true;
            }
            min = Math.min(min, nums[i]);
            stack.push(new int[]{nums[i], min});
        }
        return false;
    }

    public static void main(String[] args) {
        Pattern132 p = new Pattern132();
        int a[] = {3,1,4,2};
        p.find132pattern(a);
    }
}
