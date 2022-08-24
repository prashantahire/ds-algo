package leetecode.sorting;
import java.util.*;
// https://leetcode.com/problems/assign-cookies/
// A -> 2
// TTS -> 15
// Score: 7/10
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0,j=0;
        int count = 0;
        while(i<g.length && j<s.length){
            if(s[j] >= g[i]){
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return count;
    }
}
