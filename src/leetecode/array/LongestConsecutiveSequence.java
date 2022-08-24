package leetecode.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {

        if(nums == null || nums.length==0)
            return 0;
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        int count = 1;
        for(int i=0; i < nums.length-1; i++) {
            if(nums[i+1] - nums[i] == 1)
                count++;
            else if (nums[i+1] == nums[i]) {
                continue;
            }

            else {
                if(max < count)
                    max = count;
                count=1;
            }
        }
        if(max < count)
            max = count;
        return max;
    }

    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }

        int maxStreak = 0;
        int count = 0;
        for(int n: set) {
            if(!set.contains(n-1)) {
                int curNum = n;
                count=1;
                while(set.contains(curNum+1)){
                    curNum+=1;
                    count++;
                }
                maxStreak = Math.max(count, maxStreak);
            }
        }
        return maxStreak;
    }
}
