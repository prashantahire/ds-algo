package leetecode.binarysearch;

public class SearchInRotatedSortedArrDups {

    public static void main(String ...args){
        int a[]={2,5,6,0,0,1,2};
        System.out.println(new SearchInRotatedSortedArrDups().search(a, 0));
        System.out.println(new SearchInRotatedSortedArrDups().search(a, 3));
        System.out.println(new SearchInRotatedSortedArrDups().rotatedSearch(0, a.length-1, a, 0));
        System.out.println(new SearchInRotatedSortedArrDups().rotatedSearch(0, a.length-1, a, 3));

    }
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0)
            return false;
        int pvot = getPivotIndex(0, nums.length-1, nums);
        return pvot == -1 ? binarySearch(0, nums.length-1, nums, target) != -1 :
                binarySearch(0, pvot, nums, target) != -1 ? true : binarySearch(pvot+1, nums.length-1, nums, target) != -1;
//        if(pvot == -1)
//            return binarySearch(0, nums.length-1, nums, target) != -1;
//        if(binarySearch(0, pvot, nums, target) != -1)
//            return true;
//        return binarySearch(pvot+1, nums.length-1, nums, target) != -1;
    }

    public int binarySearch(int i, int j, int a[], int target){
        while(i<=j){
            int m = (i+j)/2;
            if(a[m] == target)
                return m;
            if(target > a[m])
                i=m+1;
            else
                j=m-1;
        }
        return -1;
    }
    public int getPivotIndex(int i, int j, int a[]){
        if(i>j)
            return -1;
        int m = (i+j)/2;
        if(m < a.length-1 && a[m] > a[m+1])
            return m;
        if(m >0 && a[m] < a[m-1])
            return m-1;
        int pvot = getPivotIndex(i, m-1, a);
        if(pvot == -1)
            return  getPivotIndex(m+1, j, a);
        return pvot;
    }

    //final solution
    public boolean rotatedSearch(int i, int j, int a[], int target){
        if(i>j)
            return false;
        int m = (i+j)/2;
        if(a[m] == target)
            return true;
        if(a[i] < a[m]){
            if(target > a[i] && target<a[m])
                return rotatedSearch(i, m-1, a, target);
            return rotatedSearch(m+1, j, a, target);
        }
        if(a[j] > a[m]) {
            if (target > a[m] && target < a[j])
                return rotatedSearch(m + 1, j, a, target);
            return rotatedSearch(i, m - 1, a, target);
        }
        return rotatedSearch(i, m-1, a, target) || rotatedSearch(m+1, j, a, target);
    }

    public boolean searchFinal(int[] nums, int target) {

        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) / 2;
            if (nums[m] == target)
                return true;
            if (nums[i] < nums[m]) {
                if (target > nums[i] && target < nums[m])
                    j = m - 1;
                else
                    i = m + 1;
            }
            if(nums[j] > nums[m]){
                if (target > nums[m] && target < nums[j])
                    i = m+1;
                else
                    j=m-1;
            }
            j--;
        }
        return false;
    }

    public boolean search3(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = -1;
        while(start <= end) {
            mid = (start + end) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //If we know for sure left side is sorted or right side is unsorted
            if (nums[mid] > nums[start] || nums[mid] > nums[end]) {
                if (target < nums[mid] && target >= nums[start]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
                //If we get here, that means nums[start] == nums[mid] == nums[end], then shifting out
                //any of the two sides won't change the result but can help remove duplicate from
                //consideration, here we just use end-- but left++ works too
            } else
            //If we know for sure right side is sorted or left side is unsorted
            if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }

            }  else {
                end--;
            }
        }

        return false;
    }
}
