package leetecode.array;
//https://leetcode.com/problems/rotate-array/submissions/
public class RotatedArray {

    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length ==0) return;
        int len = nums.length;
        k=k%len;
        rotateArr(nums, 0, len-k-1);
        rotateArr(nums, len-k, len-1);
        rotateArr(nums,0, len-1);
    }

    private void rotateArr(int a[], int s, int e){
        for(int i=s, j=e; i<j; i++, j--){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
}
