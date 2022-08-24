package leetecode.dynaprog;

import java.util.HashSet;
import java.util.Set;
//https://leetcode.com/problems/unique-substrings-in-wraparound-string/
// score: 2/10;
//TODO repeat
public class UniqueSubStrsInWraparoundString {
    public int findSubstringInWraproundString(String p) {
        int count=0;
        Set<String> added = new HashSet<>();
        for(int i=0; i<p.length(); i++){
            for(int j=i; j<p.length(); j++) {
                if(i==j){
                    if(!added.contains(p.substring(i, j+1))) {
                        count++;
                        added.add(p.substring(i, j+1));
                    }
                    continue;
                }
                if(added.contains(p.substring(i, j+1))) {
                    continue;
                }

                if(p.charAt(j)-p.charAt(j-1) == 1 || p.charAt(j)-p.charAt(j-1) == -25){
                    added.add(p.substring(i, j+1));
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public int findSubstringInWraproundString2(String p) {
        int count[] = new int[26];
        int maxLen = 0;
        for(int i=0; i<p.length(); i++) {
            if(i>0 && (p.charAt(i) - p.charAt(i-1) == 1 || p.charAt(i-1)-p.charAt(i) == 25)){
                maxLen++;
            } else {
                maxLen = 1;
            }
            count[p.charAt(i)-'a'] = Math.max(maxLen, count[p.charAt(i)-'a']);
        }
        int sum=0;
        for(int c: count)
            sum+=c;
        return sum;
    }
}
