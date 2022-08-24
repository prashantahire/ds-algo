package leetecode.array.sort;

public class KthLargestElement {

    public static void main(String ...args){
        KthLargestElement ke = new KthLargestElement();
        int a[] = {3,2,1,5,6,4};
        System.out.println(ke.findKthLargest(a, 2));
    }
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || nums.length <k)
            return 0;

        int hs = nums.length-1;
        while (hs >= 0){
            maxHeap(nums,hs);
            int temp = nums[0];
            nums[0] = nums[hs];
            nums[hs] = temp;
            if(hs == nums.length-k)
                break;
            hs--;
        }
        return nums[hs];
    }

    private void maxHeap(int a[], int hs){
        for(int i=hs/2; i>=0; i--){
            maxHeapify(i, a, hs);
        }
    }

    private void maxHeapify(int i, int a[], int hs){
        int li = i;
        int lc = 2*i+1;
        int rc = 2*i+2;
        li = lc <= hs && a[li] < a[lc] ? lc : li;
        li = rc <= hs && a[li] < a[rc] ? rc : li;
        if(li != i){
            int temp = a[i];
            a[i] = a[li];
            a[li] = temp;
            maxHeapify(li, a, hs);
        }
    }
}
