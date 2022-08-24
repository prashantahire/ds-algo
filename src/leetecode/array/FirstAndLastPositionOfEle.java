

package leetecode.array;


public class FirstAndLastPositionOfEle {
    
    public static void main(String ...args) {
        FirstAndLastPositionOfEle fl = new FirstAndLastPositionOfEle();
        int a[] = {5,7,7,8,8,10};
        int ans[] = fl.searchRange(a, 8);
        System.out.println(ans[0] + " - " + ans[1]);
    }
    public int[] searchRange(int[] nums, int target) {
        int i = 0, j = nums.length, m, ei = -1;
        int ans[] = { -1, -1 };
        if (nums == null || nums.length == 0)
            return ans;

        while (i <= j) {
            m = (i + j) / 2;
            if (target == nums[m]) {
                ei = m;
                break;
            }
            else if (target > nums[m]) {
                i = m + 1;
            }
            else
                j = m - 1;
        }
        if (ei == -1)
            return ans;
        i = ei;
        j = ei;
        while (i >= 0 && nums[i] == target)
            i--;
        while (j < nums.length && nums[j] == target)
            j++;
        ans[0] = i+1;
        ans[1] = j-1;
        return ans;
    }


    //True logn

    public int[] searchRange2(int[] nums, int target) {

        if(nums == null || nums.length ==0)
            return new int[]{-1,-1};
        int a[] = {-1,-1};
        int leftIdx = bsIdx(nums, target,true);
        if(leftIdx == nums.length || nums[leftIdx] != target){
            return a;
        }
        a[0] = leftIdx;
        a[1] = bsIdx(nums,target,false)-1;
        return a;
    }

    private int bsIdx(int a[], int target, boolean left){
        int i=0, j=a.length-1;
        while (i<=j){
            int m = (i+j)/2;
            if(a[m] > target || (a[m] == target && left)){
                j=m-1;
            }else
                i=m+1;
        }
        return i;
    }
}
