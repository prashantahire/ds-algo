package leetecode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 */

public class LongestSubstrWithoutRepeatingChars {
    
    public static void main(String ...args) {
        LongestSubstrWithoutRepeatingChars l = new LongestSubstrWithoutRepeatingChars();
        //System.out.println(l.longestSubstrLen("abcabcbb"));
//        System.out.println(l.longestSubstrLenOptiomized("abcabcbb"));
//        System.out.println(l.longestSubstrLenOptiomized("pwwkew"));
//        System.out.println(l.longestSubstrLenOptiomized(" "));
//        System.out.println(l.longestSubstrLenOptiomized("au"));
        System.out.println(l.longestSubstrLenOptiomized("abba"));
    }
    public int longestSubstrLen(String s) {
        int mmaxLen = 0;
        Set<Character> set = new HashSet<>();
        for(int i=0; i<s.length(); i++) {
            for(int j=i; j<s.length(); j++) {
                if(!set.contains(s.charAt(j))) {
                    set.add(s.charAt(j));
                    if(mmaxLen < j-i+1){
                        mmaxLen = j-i+1;
                    }
                    }
                else {
                    if(mmaxLen < j-i){
                        mmaxLen = j-i;
                    }
                    break;
                }
            }
            set.clear();
        }
        return mmaxLen;  
    } 
    
    public int longestSubstrLenOptiomized(String s) {
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        int j=0, i=-1;
        while(j<s.length()) {
            if(!map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), j);
                maxLen = Math.max(maxLen, j-i);
                j++;
            }else {
                if(i<map.get(s.charAt(j)))
                    i = map.get(s.charAt(j));
                map.remove(s.charAt(j));
            }
        }
        return maxLen;
    }
}
