package leetecode.array;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static void main(String ...args){
        SummaryRanges s = new SummaryRanges();
        int a[] = {0,2,3,4,6,8,9};
        System.out.println(s.summaryRanges(a));
    }
    public List<String> summaryRanges(int[] nums) {

        List<String> ans = new ArrayList<>();
        int prev = nums[0];
        int rs = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i]-prev != 1){
                if(rs == prev)
                    ans.add(rs+"");
                else
                    ans.add(rs+"->"+prev);
                rs = nums[i];
            }
            prev = nums[i];
        }
        if(rs ==prev)
            ans.add(rs+"");
        else
            ans.add(rs+"->"+prev);
        return ans;
    }
}
