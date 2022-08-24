package leetecode.array.sort;

public class RotatedSortedArr {

    public static void main(String ...args){
        RotatedSortedArr rs = new RotatedSortedArr();
        int a[]={1,2,3,4,5,6,0};
        System.out.println(rs.findMin(a));
    }

    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1 || nums[0] < nums[nums.length -1 ])
            return nums[0];
        return findMinBS(0, nums.length-1, nums);
    }

    public int findMinBS(int l, int h, int a[]){
        int m = (l+h)/2;

        if(a[m+1]<a[m])
            return a[m+1];
        if(a[m-1] > a[m])
            return a[m];

        if(a[l] > a[m])
            return findMinBS(l, m-1, a);
        else
            return findMinBS(m+1, h, a);
    }
}
