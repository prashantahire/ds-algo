package leetecode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubSets {

    public static void main(String ...args){
        int a[]={1,2,3};
        System.out.println(new SubSets().subsets(a));
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ss = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        subsetBt(0, nums, set, ss);
        return ss;
    }

    private void subsetBt(int i, int a[], List<Integer> set, List<List<Integer>> ss){
        ss.add(new ArrayList<>(set));
        for(int j=i; j<a.length; j++){
            set.add(a[j]);
            subsetBt(j+1, a, set, ss);
            set.remove(set.size()-1);
        }
    }
}
