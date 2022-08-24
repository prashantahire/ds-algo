package leetecode.array;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

//https://leetcode.com/problems/contains-duplicate-ii/
public class ContainsDuplicate2 {

    public static void main(String ...args){
        ContainsDuplicate2 cd = new ContainsDuplicate2();
        int a[]={1,2,3,1,2,3};
        System.out.println(cd.containsNearbyDuplicate(a, 2));
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null)
            return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                if(i-map.get(nums[i]) == k)
                    return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

}
