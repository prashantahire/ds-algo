package leetecode.sorting;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/submissions/
// TIme to solve: 50 mins
// score -> 6/10
public class MinNumArrowsToBurstBalloon {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (p1, p2) ->  p1[0] < p2[0] ? -1 : p1[0] > p2[0] ? 1:0);
        int arrowCnt = 1;
        int endMin = points[0][1];
        for(int i=1; i<points.length; i++) {
            if(points[i-1][1] >= points[i][0]) {
                if(endMin >= points[i][0])
                    endMin = Math.min(endMin, points[i][1]);
                else {
                    endMin = points[i][1];
                    arrowCnt++;
                }
            } else {
                endMin = points[i][1];
                arrowCnt++;
            }
        }
        return arrowCnt;
    }

    public static void main(String[] args) {
        MinNumArrowsToBurstBalloon mn = new MinNumArrowsToBurstBalloon();
        int a[][] = {{-2147483646,-2147483645},{2147483646,2147483647}};
        int b[][] = {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
        mn.findMinArrowShots(b);
    }
}
