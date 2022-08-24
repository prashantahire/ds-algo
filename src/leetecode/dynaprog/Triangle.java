package leetecode.dynaprog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

    public static void main(String ...args){
        List a = new ArrayList();
        a.add(Arrays.asList(2));
        a.add(Arrays.asList(3,4));
        a.add(Arrays.asList(6,5,7));
        a.add(Arrays.asList(4,1,8,3));
        System.out.println(new Triangle().minimumTotalDpWithSPaceImprove(a));

        List b = new ArrayList();
        b.add(Arrays.asList(-1));
        b.add(Arrays.asList(2,3));
        b.add(Arrays.asList(1,-1,-3));
        //System.out.println(new Triangle().minimumTotalDpWithSPaceImprove(b));

    }
    public int minimumTotal(List<List<Integer>> triangle) {
        return minTotalBtFinal(0,0,triangle);
    }
    public int minTotalBtFinal(int i, int j, List<List<Integer>> triangle){
        if(i >= triangle.size())
            return 0;
        return triangle.get(i).get(j) + Math.min(minTotalBtFinal(i+1, j, triangle), minTotalBtFinal(i+1, j+1, triangle));
    }

    public int minimumTotalDp2(List<List<Integer>> triangle) {
        if(triangle == null || triangle.size() == 0)
            return 0;
        if(triangle.size() == 1)
            return triangle.get(0).get(0);

        int a[][] = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        for(int i=0; i<a.length; i++){
            Arrays.fill(a[i], Integer.MAX_VALUE);
        }
        a[0][0] = triangle.get(0).get(0);
        for(int i=1; i<triangle.size(); i++){
            for(int j=0; j<triangle.get(i).size(); j++){
                a[i][j] = triangle.get(i).get(j) + (j > 0 ? Math.min(a[i-1][j], a[i-1][j-1]) : a[i-1][j]);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int b : a[triangle.size()-1]){
            if(min > b)
                min = b;
        }
        return min;
    }

    //Please do next time...
    public int minimumTotalDpWithSPaceImprove(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;
        if (triangle.size() == 1)
            return triangle.get(0).get(0);
        int a[] = new int[triangle.size()+1];

            Arrays.fill(a, Integer.MAX_VALUE);

        a[0] = triangle.get(0).get(0);
        for(int i=1; i<triangle.size(); i++){
            for(int j=1; j<=triangle.get(i).size(); j++) {
                a[j] = triangle.get(i).get(j) + (j > 1 ? Math.min(a[j-1], a[j-2]) : a[j-1]);
            }
        }
        return a[0];
    }
        public int minimumTotalDp(List<List<Integer>> triangle) {
        int a[] = new int[triangle.size()];
        for(int i=0; i<triangle.size(); i++){
            a[i] = triangle.get(triangle.size()-1).get(i);
        }
        for(int i=triangle.size()-2; i>=0; i--){
            for(int j=0; j<triangle.get(i).size(); j++){
                a[j] = Math.min(a[j]+triangle.get(i).get(j), a[j+1]+triangle.get(i).get(j));
            }
        }
        return a[0];
    }
}
