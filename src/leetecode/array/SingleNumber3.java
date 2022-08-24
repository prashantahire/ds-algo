package leetecode.array;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber3 {

    public static void main(String ...args){
        SingleNumber3 sn3 = new SingleNumber3();
        int a[] = {1,2,1,3,2,5};
        sn3.singleNumber2(a);
    }
    public int[] singleNumber(int[] nums) {

        if(nums == null || nums.length==0)
            return new int[0];
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            if(set.contains(n))
                set.remove(n);
            else
                set.add(n);
        }
        int a[] = set.stream().mapToInt(i -> i).toArray();
        return a;
    }

    public int[] singleNumber2(int[] nums) {
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        // Get its last set bit
        diff &= -diff;

        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums)
        {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            }
            else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
    }
}
