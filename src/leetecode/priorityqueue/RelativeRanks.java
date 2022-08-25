package leetecode.priorityqueue;

import java.util.*;
public class RelativeRanks {
    // TIme - (nlogn)
    // Space - O(n)
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e2[0]-e1[0]);
        for(int i=0; i<score.length; i++){
            pq.offer(new int[]{score[i], i});
        }
        String ans[] = new String[score.length];
        int i=1;
        while(!pq.isEmpty()){
            int t[] = pq.poll();
            String rank = i == 1? "Gold Medal" : i==2 ? "Silver Medal" : i == 3 ? "Bronze Medal" : ""+i;
            i++;
            ans[t[1]] = rank;
        }
        return ans;
    }
}
