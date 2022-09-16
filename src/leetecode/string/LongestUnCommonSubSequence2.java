package leetecode.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestUnCommonSubSequence2 {

    // Not working as subsequence check is missing
    public int findLUSlength(String[] strs) {
        int maxLen = -1;
        boolean dup = false;
        for(int i=0; i<strs.length; i++){
            for(int j=0; j<strs.length; j++){
                if( i != j && (strs[i].equals(strs[j]) || strs[j].contains(strs[i]))){
                    dup = true;
                    break;
                }
            }
            if(!dup){
                maxLen = Math.max(maxLen, strs[i].length());
            }
            dup = false;
        }
        return maxLen;
    }

    // Time: O(n^2*m)
    // Space: O(n)
    public int findLUSlength2(String[] strs) {
        Arrays.sort(strs, (s1, s2) -> s2.length()-s1.length());
        Set<String> dups = getDups(strs);

        for(int i=0; i<strs.length; i++){
            if(i==0 && !dups.contains(strs[i]))
                return strs[i].length();
            if(!dups.contains(strs[i])){
                for(int j=0; j<i; j++){
                    if(isSubSeq(strs[j], strs[i])){
                       break;
                    }
                    if(j == i-1)
                        return strs[i].length();
                }
            }
        }
        return -1;
    }

    private boolean isSubSeq(String s1, String s2){
        int i=0, j=0;
        while (i<s1.length() && j<s2.length()){
            if(s1.charAt(i)==s2.charAt(j))
                j++;
            i++;
        }
        return j == s2.length();
    }
    private Set<String> getDups(String[] strs){
        Set<String> dups = new HashSet<>();
        Set<String> set = new HashSet<>();
        for(String s: strs){
            if(set.contains(s))
                dups.add(s);
            set.add(s);
        }
        return dups;
    }
}
