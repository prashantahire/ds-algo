package leetecode;

import java.util.*;

public class Sum_3 {
    
    public static void main(String ...args) {
        Sum_3 sum = new Sum_3();
        int a[] = {-1, 0, 1, 2, -1, -4};
        System.out.println(sum.threeSum(a));
    }
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3)
            return null;
        List<List<Integer>> ans = new ArrayList<>();
        int sum = nums[0]+nums[1]+nums[2];
        if(sum == 0) {
            ans.add(Arrays.asList(nums[0],nums[1],nums[2]));
        }
        for(int i=1; i<nums.length-2; i++) {
            sum = sum - nums[i-1]+nums[i+2];
            if(sum == 0)
                ans.add(Arrays.asList(nums[i],nums[i+1],nums[i+2]));
        }
        return ans;
    }

    public List<List<Integer>> threeSumBt(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        if(nums == null || nums.length==0)
            return new ArrayList<>(ans);;
        threeSumBTRec(0,0,0,nums,list, ans);
        return new ArrayList<>(ans);
    }
    private void threeSumBTRec(int i, int cnt, int sum, int a[], List<Integer> list, Set<List<Integer>> ans){
        if(cnt >=3){
            if(sum == 0)
                ans.add(new ArrayList<>(list));
            return;
        }
        for(int j=i; j<a.length; j++){
            list.add(a[j]);
            threeSumBTRec(j+1, cnt+1, sum+a[j], a,list, ans);
            list.remove(list.size()-1);
        }
    }

    public List<List<Integer>> threeSumDp(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length==0)
            return ans;
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++){

            if(i>0 && nums[i] == nums[i-1])
                continue;

            int j=i+1;
            int k= nums.length-1;

            while (j<k){
                int sum = nums[i] + nums[j] +nums[k];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j<k && nums[j] == nums[j-1]) j++;
                    while (j<k && nums[k] == nums[k+1]) k--;
                }else if(sum > 0)
                    k--;
                else
                    j++;
            }
        }
        return ans;
    }
}
