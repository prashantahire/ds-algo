package leetecode.array.sort;

public class MergeSortedArr {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        reverse(nums1,0,m-1);
        reverse(nums1, 0, nums1.length);
        int i=n-1,j=0, k=0;
        while (i<nums1.length && j<n){
            if(nums1[i] < nums2[j]){
                nums1[k] = nums1[i];
                i++;
                k++;
            }else{
                nums1[k] = nums2[j];
                j++;
                k++;
            }
        }
        while (i<nums1.length){
            nums1[k] = nums1[i];
            i++;
            k++;
        }
        while (j<nums2.length){
            nums1[k] = nums2[j];
            k++;
            j++;
        }
    }

    private void reverse(int a[], int s, int e){
        while(s<e){
            int temp = a[s];
            a[s] = a[e];
            a[e] = temp;
            s++;
            e--;
        }
    }
}
