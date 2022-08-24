package leetecode.sorting;

public class SortColors {

    public static void main(String ...args){
        int a[]={2, 2, 1, 0, 0, 2};
        sortColors(a);
        for(int i=0; i<a.length; i++)
        System.out.println(a[i]);
    }
    public static void sortColors(int[] nums) {
        if(nums == null || nums.length==0)
            return;
        int i=-1, j=-1, k=-1;
        for(int l=0; l<nums.length; l++){
            if(nums[l] == 0){
                i++;
                nums[i] = 0;
                if(j!=-1){
                    j++;
                    nums[j] = 1;
                }
                if(k!=-1){
                    k++;
                    nums[k] = 2;
                }
            }else if(nums[l] == 1){
                j = j == -1 && i!=-1 ? i+1 : j+1;
                nums[j]=1;
                if(k!=-1)
                {
                    k++;
                    nums[k] = 2;
                }
            }else{
                k= k==-1 && j!=-1 ? j+1 : k==-1 && i!=-1? i+1 : k+1;
                nums[k] = 2;
            }

        }
    }

    //Final https://www.geeksforgeeks.org/3-way-quicksort-dutch-national-flag/

    /**
     * Concept user 3 way partition quick sort
     * @param nums
     */
    public static void sortColorsFinal(int[] nums) {

        int i=0, lt=0, gt=nums.length-1;
        while (i<=gt){
            if(nums[i] == 0){
                swap(nums, i, lt);
                i++;
                lt++;
            }else if(nums[i] == 2){
                swap(nums, i, gt);
                gt--;
            }else
                i++;
        }
    }

    private static void swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
