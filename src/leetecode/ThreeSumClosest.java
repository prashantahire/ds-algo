

package leetecode;


import java.util.Arrays;


public class ThreeSumClosest {

    public static void main(String... args) {
        ThreeSumClosest ts3 = new ThreeSumClosest();
        int a[] = { 1, 2, 5, 10, 11 };
        System.out.println(ts3.threeSumClosest(a, 12));
    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);
        int ans = 0;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int twoTS = twoSumClosest(i + 1, nums.length - 1, nums, target - nums[i]);
            int ts3 = nums[i] + twoTS;
            if (minDiff > Math.abs(target - ts3)) {
                minDiff = Math.abs(target - ts3);
                ans = ts3;
            }
        }
        return ans;
    }

    private int twoSumClosest(int l, int h, int a[], int ts) {

        int i = l, j = h;
        int minSum = Integer.MAX_VALUE;
        int minDiff = Integer.MAX_VALUE;
        while (i < j) {
            if (a[i] + a[j] == ts) {
                return ts;
            }
            if (a[i] + a[j] > ts) {
                if (minDiff > Math.abs(ts - (a[i] + a[j]))) {
                    minDiff = Math.abs(ts - (a[i] + a[j]));
                    minSum = a[i] + a[j];

                }
                j--;
            }
            else if (a[i] + a[j] < ts) {
                if (minDiff > Math.abs(ts - (a[i] + a[j]))) {
                    minDiff = Math.abs(ts - (a[i] + a[j]));
                    minSum = a[i] + a[j];
                }
                i++;
            }
        }
        return minSum;
    }

    public int threeSumClosestImpro(int[] nums, int target) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int ans = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2; i++){

            int j=i+1;
            int k=nums.length-1;

            while (j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum > target)
                    k--;
                else
                    j++;
                if(Math.abs(sum-target) < Math.abs(ans-target))
                    ans = sum;
            }
        }
        return ans;
    }

}
