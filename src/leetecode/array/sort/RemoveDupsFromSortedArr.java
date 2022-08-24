package leetecode.array.sort;

public class RemoveDupsFromSortedArr {

    public static void main(String ...args){
        int a[] = {1,1,1,2,2,3};
        int j = removeDuplicates(a);
        System.out.println(j);
        print(a, j);

        int b[]={0,0,1,1,1,1,2,3,3};
        j = removeDuplicates(b);
        System.out.println(j);
        print(b, j);

    }
    public static int removeDuplicates(int[] nums) {
        int i=0,j=0;
        while(i<nums.length){
            nums[j] = nums[i];
            j++;
            i++;
            boolean isDup =false;
            while(i<nums.length && nums[i] == nums[i-1]){
                isDup = true;
                i++;
            }
            if(isDup){
                nums[j] = nums[i-1];
                j++;
            }
        }
        return j;
    }

    public static void print(int a[], int j){
        for(int i = 0; i<j; i++)
            System.out.print(a[i]+" ");

    }
}
