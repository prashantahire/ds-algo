package leetecode.array.sort;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {

        int i=0, j=nums.length-1;
        while (i<=j){
            int m = (i+j)/2;
            if(nums[m] == target)
                return m;
            if(target > nums[m])
                i=m+1;
            else
                j=m-1;
        }
        return i;
    }
}
