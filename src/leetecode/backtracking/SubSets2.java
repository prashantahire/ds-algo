package leetecode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets2 {

    public static void main(String ...args){
        int a[]={4,4,4,1,4};
        System.out.println(new SubSets2().subsetsWithDup(a));
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> fl = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        subsetDfs(0, nums, list, fl);
        return fl;
    }
    public void subsetDfs(int i, int a[], List<Integer> list, List<List<Integer>> fl){
        fl.add(new ArrayList<>(list));
        for(int j=i; j<a.length; j++){
            if(j>i && a[j]==a[j-1])
                continue;
            list.add(a[j]);
            subsetDfs(j+1, a, list, fl);
            list.remove(list.size()-1);
        }
    }
}
