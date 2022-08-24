package leetecode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSum_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        ksumBt(4,0,nums.length-1, target,nums,list,ans);
        return ans;
    }

    private void ksumBt(int k, int start, int end, int target, int a[], List<Integer> list, List<List<Integer>> ans){
        if(k == 0 || a.length ==0 || start>end)
            return;

        if(k==1){
            for(int i=start; i<=end; i++){
                if(a[i] == target){
                    list.add(a[i]);
                    ans.add(new ArrayList<>(list));
                    list.remove(list.size()-1);
                }
            }
            return;
        }

        if(k==2){
            while (start < end){
                int sum = a[start]+a[end];
                if(sum == target){
                    list.add(a[start]);
                    list.add(a[end]);
                    ans.add(new ArrayList<>(list));
                    list.remove(list.size()-1);
                    list.remove(list.size()-1);
                    start++;
                    end--;

                    //avoid dups
                    while(start < end && a[start] == a[start-1]) start++;
                    while (start<end && a[end] == a[end+1]) end++;
                }else if(sum < target)
                    start++;
                else
                    end--;
            }
            return;
        }

        //check if possible to get such pairs
        if(k*a[start] > target || k*a[end]<target) return;

        for(int i=start; i<=end-k+1; i++){
            if(i>start && a[i]==a[i-1])
                continue;

            //check if possible to get such pairs
            if(k*a[i] <= target) {
                list.add(a[i]);
                ksumBt(k - 1, i + 1, end, target - a[i], a, list, ans);
                list.remove(list.size() - 1);
            }
        }
    }
}
