package leetecode.sorting;

import java.time.LocalDate;

public class MedianUsingQuickSelect {

    public int getMedian(int nums[]){
        return quickSelect(nums, 0, nums.length-1, nums.length/2);
    }
    private int quickSelect(int []a, int l, int r, int med) {
        if(l<=r){
            int pidx = partition(a, l, r);
            if(pidx == med)
                return med;
            if(pidx > med)
                return quickSelect(a, l, pidx-1, med);
            return quickSelect(a, pidx+1, r, med);
        }
        return -1;
    }

    private int partition(int a[], int l, int r){
        int pidx = r;
        int pivot = a[pidx];
        int i=l;
        for(int j=i; j<r; j++) {
            if(a[j] < pivot) {
                swap(a, i, j);
                i++;
            }
        }
        swap(a, pidx, i);
        return i;
    }

    private void swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        MedianUsingQuickSelect ms = new MedianUsingQuickSelect();
        int a[] = {1,2,5,8,0};
        System.out.println(ms.getMedian(a));

        LocalDate esdate = LocalDate.now().minusDays(1L);
        LocalDate startdate = LocalDate.now();
        LocalDate d22 = LocalDate.now();
        LocalDate endDate = LocalDate.now().plusDays(1L);
        LocalDate eeDate = LocalDate.now().plusDays(2L);
        System.out.println(startdate.compareTo(esdate));
        System.out.println(endDate.compareTo(eeDate));
    }
}
