package leetecode.backtracking;

import java.util.*;

public class IncreasingSubsequences {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        findSubsequencesRec(0, nums, new ArrayList<>());
        return ans;
    }
    Set<String> set = new HashSet<>();
    public void findSubsequencesRec(int i, int[] nums, List<Integer> list) {
        if(i>=nums.length){
            return;
        }

        for(int j=i; j<nums.length; j++) {
            if(list.isEmpty()){
                list.add(nums[j]);
                findSubsequencesRec(j+1, nums, list);
                list.remove(0);
            } else {
                if(list.get(list.size()-1) <= nums[j]){
                    list.add(nums[j]);
                    if(!set.contains(list.toString())) {
                        ans.add(new ArrayList<>(list));
                        set.add(list.toString());
                        findSubsequencesRec(j+1, nums, list);
                    }
                    list.remove(list.size()-1);
                }
            }
        }
    }

    List<List<Integer>> ans2 = new ArrayList<>();
    public List<List<Integer>> findSubsequences2(int[] nums) {
        findSubsequencesRec(0, nums, new LinkedList<>());
        return ans2;
    }
    public void findSubsequencesRec2(int i, int[] nums, List<Integer> list) {
        if(i>=nums.length){
            return;
        }
        Set<Integer> set = new HashSet<>();
        for(int j=i; j<nums.length; j++) {
            if(set.contains(nums[j]))
                continue;
            if(list.isEmpty()){
                list.add(nums[j]);
                findSubsequencesRec2(j+1, nums, list);
                list.remove(0);
                set.add(nums[j]);
            } else {
                if(list.get(list.size()-1) <= nums[j]){
                    list.add(nums[j]);
                    set.add(nums[j]);
                    ans.add(new ArrayList<>(list));
                    findSubsequencesRec2(j+1, nums, list);
                    list.remove(list.size()-1);
                }
            }
        }
    }
}
