package leetecode.array;

import java.util.ArrayList;
import java.util.List;


//ALgo used https://gregable.com/2013/10/majority-vote-algorithm-find-majority.html
public class MajorityElement2 {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int cand1=0, cand2=0, count1=0, count2=0;
        for(int i=0; i<nums.length; i++){
            if(cand1== nums[i])
                count1++;
            else if(cand2 == nums[i])
                count2++;
            else if(count1 == 0) {
                cand1 = nums[i];
                count1=1;
            }else if(count2 == 0){
                count2 = 1;
                cand2 = nums[i];
            }else {
                count1--;
                count2--;
            }
        }

        count1=0; count2=0;
        int trg = nums.length/3;
        for(int n : nums){
            if(n == cand1)
                count1++;
            else if(n==cand2)
                count2++;
        }
        if(count1 > trg)
            ans.add(cand1);
        if(count2 > trg)
            ans.add(cand2);
        return ans;
    }
}
