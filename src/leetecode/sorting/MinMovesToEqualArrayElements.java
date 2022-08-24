package leetecode.sorting;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-moves-to-equal-array-elements-ii/
// score: 4/10

public class MinMovesToEqualArrayElements {

    //nlogn
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        int midNum = nums[nums.length/2];
        for(int i: nums){
            count += Math.abs(midNum-i);
        }
        return count;
    }

    // O(n) avg
    public int minMoves3(int[] nums) {
        int count = 0;
        //getMedian(nums);
        int midNum = nums[getMedian(nums)];
        for(int i: nums){
            count += Math.abs(midNum-i);
        }
        return count;
    }

    private int getMedian(int nums[]){
        return quickSelect(nums, 0, nums.length-1, nums.length/2);
    }
    private int quickSelect(int []a, int l, int r, int med) {
        if(l<=r){
            int pidx = partition(a, l, r);
            if(pidx == med)
                return med;
            if(pidx > med)
                return quickSelect(a, l, pidx-1, med);
            return quickSelect(a, pidx+1, r, med);
        }
        return -1;
    }

    private int partition(int a[], int l, int r){
        int pidx = r;
        int pivot = a[pidx];
        int i=l;
        for(int j=i; j<r; j++) {
            if(a[j] < pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, pidx, i);
        return i;
    }

    private void swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
