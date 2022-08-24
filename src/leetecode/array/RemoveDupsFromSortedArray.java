//https://leetcode.com/problems/remove-duplicates-from-sorted-array/

package leetecode.array;


public class RemoveDupsFromSortedArray {
    
    public static void main(String ...args) {
        int a[] = {0,0,1,1,1,2,2,3,3,4};
        RemoveDupsFromSortedArray rm = new RemoveDupsFromSortedArray();
        System.out.println(rm.removeDuplicatesFinal(a));
    }
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 1;
        while (j < nums.length) {
            while (j<nums.length &&nums[i] == nums[j])
                j++;
            if (j<nums.length && j > i + 1) {
                nums[i + 1] = nums[j];
                i++;
            }
            else {
                i++;
                j++;
            }
        }
        return i;
    }

    public int removeDuplicatesFinal(int[] nums) {
        int cnt = 1;
        int i=1,j=1;

        //k can be any no. of dup, here 2
        int k=2;

        while (j<nums.length){

            //if prev != curr, simply copy j to i and reset cnt
            if(nums[j]!=nums[j-1]){
                nums[i] = nums[j];
                i++;
                cnt=1;
            }else {
                // if cur == prev and cnt < 2
                if(cnt < k){
                    nums[i] = nums[j];
                    i++;
                    cnt++;
                }
            }
            //skip element
            j++;

        }
        return i;
    }
}
