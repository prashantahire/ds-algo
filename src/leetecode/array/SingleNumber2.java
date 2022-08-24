package leetecode.array;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber2 {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length ==0)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int si = 0;
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i])+1);
            else{
                map.put(nums[i], 1);
            }
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet())
            if(entry.getValue() ==1)
                return entry.getKey();
            return 0;
    }
}
