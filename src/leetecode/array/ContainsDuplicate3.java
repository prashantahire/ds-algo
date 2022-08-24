package leetecode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ContainsDuplicate3 {

    public static void main(String... args) {
        int a[] = {-1, 2147483647};
        ContainsDuplicate3 cd = new ContainsDuplicate3();
        System.out.println(cd.containsNearbyAlmostDuplicate(a, 1, 2147483647));
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if (nums == null || nums.length == 0)
            return false;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs((long) nums[i] - (long) nums[j]) <= t && j - i <= k)
                    return true;
            }
        }
        return false;
    }

    //nlogk
    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k == 0)
            return false;
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long l = nums[i];
            Long floor = set.floor(l);
            Long ceil = set.ceiling(l);
            if ((floor != null && nums[i] - floor <= t) ||
                    (ceil != null && ceil - nums[i] <= t)) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k)
                set.remove(nums[i - k]);
        }
        return false;
    }

}
