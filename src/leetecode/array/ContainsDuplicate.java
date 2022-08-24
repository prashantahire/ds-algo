package leetecode.array;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/contains-duplicate/

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null)
            return false;
        Set<Integer> set = new HashSet<>();
        for(int e : nums){
            if(set.contains(e))
                return true;
            set.add(e);
        }
        return false;
    }
}
