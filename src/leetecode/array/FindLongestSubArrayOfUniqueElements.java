package leetecode.array;

import java.util.HashSet;
import java.util.Set;

public class FindLongestSubArrayOfUniqueElements {
    
    public static void main(String ...args) {
        int a[] = {1,2,3,4,3,1,5,6,4,7,1,7,0};
        getLongestSubArr(a);
    }
    public static void getLongestSubArr(int a[]) {
        int i=0, j=0;
        int maxLen = Integer.MIN_VALUE;
        int ei=0, si=0;
        Set<Integer> set = new HashSet<>();
        while(j<a.length) {
            if(!set.contains(a[j])) {
                set.add(a[j]);
                j++;
                if(maxLen < j-i) {
                    maxLen = j-i;
                    ei = j;
                    si = i;
                }
            }else {
                set.remove(a[i]);
                i++;
            }
        }
        for(int m=si; m<ei; m++) {
            
            System.out.println(a[m]);
        }
    }
}
