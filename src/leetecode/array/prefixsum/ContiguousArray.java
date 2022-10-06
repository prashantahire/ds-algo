package leetecode.array.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int maxLen = 0;
        for(int i=0; i<nums.length; i++){
            count += nums[i] == 0 ? -1 : 1;
            if(map.containsKey(count)){
                maxLen = Math.max(maxLen, i-map.get(count)+1);
            } else {
                map.put(count, i);
            }
        }
        return maxLen;
    }
}
