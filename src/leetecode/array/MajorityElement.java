package leetecode.array;

//https://leetcode.com/problems/majority-element/
public class MajorityElement {
    public int majorityElement(int[] nums) {
        Integer candidate = null;
        int count = 0;
        for(int num : nums){
            if(count == 0)
                candidate = num;
            count+=(num == candidate) ? 1:-1;
        }
        return candidate;
    }
}
