package leetecode.hashmap;

import java.util.*;

// https://leetcode.com/problems/4sum-ii/
// A -> 1
// TTS -> 30 mins
// score: 8/10
public class FourSum2 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Long, Integer> map = new HashMap<>();
        for(int i : nums1){
            for(int j: nums2){
                long sum = i + j;
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }
        int count = 0;
        for(int i: nums3) {
            for(int j: nums4) {

                long tsum = (i+j);
                if(map.containsKey(-tsum)){
                    count+=map.get(-tsum);
                }
            }
        }
        return count;
    }
}
