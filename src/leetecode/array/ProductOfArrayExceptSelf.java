package leetecode.array;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0)
            return nums;
        int a[] = new int[nums.length];
        int fistProd = 1, zeorCnt = 0, zeroi = -1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != 0) {
                fistProd = fistProd*nums[i];
            }else {
                zeorCnt++;
                if(zeorCnt > 1)
                    break;
                zeroi = i;
            }

        }
        if(zeorCnt > 1)  return a;
        if(zeorCnt == 1){
            a[zeroi] = fistProd;
            return a;
        }
        a[0] = fistProd/nums[0];
        for(int i=1; i<nums.length;i++){
            a[i] = (a[i-1]/nums[i])*nums[i-1];
        }
        return a;
    }

    //Without division

    public int[] productExceptSelf2(int[] nums) {
        if(nums == null || nums.length == 0)
            return nums;
        int n=nums.length;
        int leftP[] = new int[n];
        int rightP[] = new int[n];
        int ans[] = new int[n];

        //Calculate Left Prod
        leftP[0] = 1;
        for(int i=1; i<n; i++)
            leftP[i] = leftP[i-1]*nums[i-1];

        //calculate right prodcut
        rightP[n-1] = 1;
        for(int i=n-2; i>=0; i--)
            rightP[i] = rightP[i+1]*nums[i+1];

        for(int i=0; i<n; i++){
            ans[i] = leftP[i]*rightP[i];
        }
        return ans;
    }

    //spac O(1)
    public int[] productExceptSelf3(int[] nums) {
        if (nums == null || nums.length == 0)
            return nums;
        int n = nums.length;
        int ans[] = new int[n];
        ans[0] = 1;
        //calc left
        for(int i=1; i<n; i++)
            ans[i] = ans[i-1]*nums[i-1];

        int rightP = 1;

        for(int i=n-1; i>=0; i--){
            ans[i] = ans[i]*rightP;
            rightP = rightP*nums[i];
        }
        return ans;
    }
}
