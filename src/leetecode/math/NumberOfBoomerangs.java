package leetecode.math;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/number-of-boomerangs/
// 5/10
// Time: O(n)^2
// SPace: O(d)
// Try for Optimized solution next time


//https://stattrek.com/online-calculator/combinations-permutations.aspx#:~:text=The%20number%20of%20combinations%20of%20n%20distinct%20objects,r%20at%20a%20time%20is%3A&text=Cr%20%3D%20n!%20%2F%20r,(n%20%2D%20r)!&text=Thus%2C%2027%2C405%20different%20groupings%20of%204%20players%20are%20possible.
public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int boomCount = 0;
        for(int i=0; i<points.length; i++) {
            Map<Double, Integer> map = new HashMap<>();
            for(int j=0; j< points.length; j++) {
                if(i==j) continue;
                double dist = Math.sqrt(Math.pow(points[i][0]-points[j][0], 2) + Math.pow(points[i][1]-points[j][1], 2));
                if(!map.containsKey(dist)) {
                    map.put(dist, 0);
                }
                map.put(dist, map.get(dist)+1);
            }
            for(int val : map.values()) {
                if(val > 1) {
                    long cnt = factorial(val)/factorial(val-2);
                    boomCount+=cnt;
                }
            }
        }
        return boomCount;
    }

    private Long factorial(int n) {
        Long ans=1L;
        for(int i=2; i<=n;  i++){
            ans*=i;
        }
        return ans;
    }


    public int numberOfBoomerangs2(int[][] points) {
        int boomCount = 0;
        for(int i=0; i<points.length; i++) {
            Map<Double, Integer> map = new HashMap<>();
            for(int j=0; j< points.length; j++) {
                if(i==j) continue;
                Double dist = Math.pow(points[i][0]-points[j][0], 2) + Math.pow(points[i][1]-points[j][1], 2);
                if(!map.containsKey(dist)) {
                    map.put(dist, 0);
                }
                map.put(dist, map.get(dist)+1);
            }
            for(int val : map.values()) {
                if(val>1){
                    long cnt = val*(val-1);
                    boomCount+=cnt;
                }
            }
        }
        return boomCount;
    }


    public static void main(String[] args) {
        NumberOfBoomerangs nb = new NumberOfBoomerangs();
        int a[][] = {{0,0}, {1, 0}, {2, 0}};
        System.out.println(nb.numberOfBoomerangs2(a));
    }
}
