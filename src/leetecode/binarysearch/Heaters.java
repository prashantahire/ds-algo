package leetecode.binarysearch;

import java.util.Arrays;
import java.util.TreeSet;

// https://leetcode.com/problems/heaters/
public class Heaters {
    public int findRadius2(int[] houses, int[] heaters) {
        TreeSet<Integer> tree = new TreeSet<>();
        for(int ht: heaters){
            tree.add(ht);
        }

        int radius = 0;

        for(int hs: houses) {
            Integer lower = tree.floor(hs);
            Integer upper = tree.ceiling(hs);
            int nearerHeater = Math.min(lower==null? Integer.MAX_VALUE : hs-lower, upper==null ? Integer.MAX_VALUE: upper-hs);
            radius = Math.max(radius, nearerHeater);
        }
        return radius;
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int radius = 0;
        for(int hs : houses) {

            Integer[] bounds = getUpperAndLowerbounds(hs, heaters);

            int nearerHeater = Math.min(bounds[0] == null ? Integer.MAX_VALUE: hs-bounds[0], bounds[1] == null ? Integer.MAX_VALUE : bounds[1]-hs);
            radius = Math.max(radius, nearerHeater);
        }
        return radius;
    }

    private Integer[] getUpperAndLowerbounds(int hs, int[] htrs) {

        Integer ans[] = new Integer[2];
        int i=0, j= htrs.length-1;

        while(i<=j) {

            int m = i + (j-i)/2;
            if(hs == htrs[m])
                break;
            if(hs < htrs[m])
                j = m-1;
            else
                i= m+1;
        }
        if(j >= 0)
            ans[0] = htrs[j];
        if(i < htrs.length)
            ans[1] = htrs[i];
        return ans;
    }
}
