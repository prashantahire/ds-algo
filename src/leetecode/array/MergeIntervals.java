package leetecode.array;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    
    public static void main(String ...args) {
        MergeIntervals mi = new MergeIntervals();
        int a[][] = {{1,3},{4,6},{2,7},{8,10},{2,5},{10,18}};
        //mi.merge(a);
        mi.merge3(a);
    }
    public int[][] merge(int[][] intervals) {
        int cnt = 0;
        boolean isMrgd = false;
        for(int i=0; i<intervals.length; i++) {
            for(int j=i+1; j<intervals.length; j++) {
                if(intervals[i][1]>=intervals[j][0] && intervals[i][0]<=intervals[j][1]) {
                    intervals[j][0] = intervals[i][0]<intervals[j][0] ? intervals[i][0]:intervals[j][0];
                    intervals[j][1] = intervals[i][1]> intervals[j][1] ? intervals[i][1] : intervals[j][1];
                    isMrgd = true;
                }
            }
            if(isMrgd) {
                intervals[i][0] = -1;
                intervals[i][1] = -1;
                isMrgd = false;
                cnt++;
            }
        }
        if(cnt>0) {
            int b[][] = new int[intervals.length-cnt][2];
            int j=0;
            for(int i=0;i<intervals.length;i++) {
                if(intervals[i][0] != -1) {
                    b[j][0] = intervals[i][0];
                    b[j][1] = intervals[i][1];
                    j++;
                    System.out.println(intervals[i][0] +" - "+intervals[i][1]);
                }
            }
            return b;
        }
        return intervals;
    }
    
    public int[][] merge2(int[][] intervals){
        Arrays.sort(intervals, (i1, i2)->i1[0]-i2[0]);
        
        int cnt = 0;
        for(int i=0;i<intervals.length-1;i++) {
            if(intervals[i][1] >=intervals[i+1][0] && intervals[i][0]<=intervals[i+1][1]) {
                intervals[i+1][0] = intervals[i][0];
                intervals[i+1][1] = Math.max(intervals[i][1], intervals[i+1][1]);
                intervals[i][0] = -1;
                intervals[i][1] = -1;
                cnt++;
            }
        }
        if(cnt>0) {
            int b[][] = new int[intervals.length-cnt][2];
            int j=0;
            for(int i=0;i<intervals.length;i++) {
                if(intervals[i][0] != -1) {
                    b[j][0] = intervals[i][0];
                    b[j][1] = intervals[i][1];
                    j++;
                    System.out.println(intervals[i][0] +" - "+intervals[i][1]);
                }
            }
            return b;
        }
        return intervals;        
    }

    public int[][] merge3(int[][] intervals){

        Arrays.sort(intervals, (a1, a2) -> a1[0]-a2[0]);

        LinkedList<int[]> merge = new LinkedList<>();

        for(int interval[] : intervals){

            if(merge.isEmpty() || merge.getLast()[1] < interval[0]){
                merge.add(interval);
            }else{
                merge.getLast()[1] = Math.max(merge.getLast()[1], interval[1]);
            }
        }
        return (int[][])merge.toArray();
    }
}
