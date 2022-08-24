package leetecode.dynaprog;

import java.util.Arrays;

public class HouseRobber {
    public static void main(String ...args){
        int a[]={2,7,9,3,1};
        HouseRobber hr = new HouseRobber();
        System.out.println(hr.robBackTrackingSolution(a));
        System.out.println(hr.robTopDownMemo(a));
        System.out.println(hr.robBottomUp(a));
    }

    //Backtracking top down
    public int robBackTrackingSolution(int[] nums) {
        return robBt(nums, 0);
    }

    private int robBt(int a[], int i){
        if(i>=a.length)
            return 0;
        return Math.max(robBt(a,i+2)+a[i], robBt(a, i+1));
    }

    //Memoization top down

    public int robTopDownMemo(int nums[]){
        int res[] = new int[nums.length];
        Arrays.fill(res, -1);
        return robMemoTD(nums, res, 0);
    }
    private int robMemoTD(int a[],int res[], int i){
        if(i>=a.length)
            return 0;
        if(res[i] != -1)
            return res[i];
        int ans = Math.max(robMemoTD(a, res,i+2)+a[i], robMemoTD(a,res, i+1));
        res[i] = ans;
        return res[i];
    }

    //Memo bottom up
    public int robBottomUp2(int nums[]){
        int res[] = new int[nums.length+1];
        res[0] = 0;
        res[1] = nums[0];
        for(int i=1; i<nums.length; i++){
            int max = Math.max(res[i-1]+nums[i], res[i]);
            res[i+1] = max;
        }
        return res[nums.length];
    }

    public int robBottomUp(int nums[]){
        int res[] = new int[nums.length+2];
        res[0] = 0;
        res[1] = 0;
        for(int i=2; i<nums.length+2; i++){
            int max = Math.max(res[i-2]+nums[i-2], res[i-1]);
            res[i] = max;
        }
        return res[nums.length+1];
    }

    //Memo bottom up - improved space
    public int robBottomUpImporveSpace(int nums[]){
        if(nums == null || nums.length==0)
            return 0;
        int preprevRob = 0;
        int prevRob = 0;
        int maxRob = 0;
        for(int i=0; i<nums.length; i++){
            int temp = prevRob;
            prevRob = Math.max(preprevRob+nums[i], prevRob);
            preprevRob = temp;
        }
        return prevRob;
    }
}
