

package leetecode.array;


import java.util.Arrays;

//https://leetcode.com/problems/next-permutation/solution/
public class NextPermutation {

    public static void main(String... args) {
        NextPermutation np = new NextPermutation();
        int a[] = { 1, 2 };
        np.nextPermutation(a);
        Arrays.stream(a).forEach(n -> System.out.print(n + " "));
        System.out.println();
        int b[] = { 3, 2, 1 };
        np.nextPermutation(b);
        Arrays.stream(b).forEach(n -> System.out.print(n + " "));

    }

    public void nextPermutation(int[] nums) {

        int mini = -1, minj = -1, minDiff = Integer.MAX_VALUE;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i; j < nums.length - 1; j++) {
                if (nums[i] < nums[j + 1]) {
                    if (minDiff > nums[j + 1] - nums[i]) {
                        minDiff = nums[j + 1] - nums[i];
                        mini = i;
                        minj = j + 1;
                    }
                }
            }
            if (mini != -1)
                break;
        }
        if (mini != -1) {
            int temp = nums[mini];
            nums[mini] = nums[minj];
            nums[minj] = temp;
        }
        for (int i = mini != -1 ? mini + 1 : 0; i < nums.length; i++) {
            for (int j = mini != -1 ? mini + 1 : 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
    
    
    public void nextPermutation2(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
