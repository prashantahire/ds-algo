package leetecode;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindrommeSubStr {
    
    public static void main(String ...args) {
        LongestPalindrommeSubStr lp = new LongestPalindrommeSubStr();
        System.out.println(lp.longestPalindrome("babad"));
        System.out.println(lp.LongestPaliExpandAroundCenter("babad"));
    }
    public String longestPalindrome(String s) {
        int max = 0;
        String ans = "";
        for(int i=0; i<s.length(); i++) {
            for(int j=i+1; j<=s.length(); j++) {
                String s1 = s.substring(i, j);
                if(isPalindrome(s1)) {
                    if(max < s1.length()) {
                        ans = s1;
                        max = s1.length();
                    }
                }
            }
        }
        return ans;
    }
        public boolean isPalindrome(String s) {
        int i=0, j=s.length()-1;
        while(i<j) {
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
        
        public String LongestPaliExpandAroundCenter(String s) {
            
            if(s == null || s.length() == 1)
                return s;
            int start = 0, end = 0;
            for(int i=0; i<s.length(); i++) {
                
                int len1 = expandAroundCircle(s, i, i);
                int len2 = expandAroundCircle(s, i, i+1);
                
                int len = Math.max(len1, len2);
                if(len > end-start) {
                    start = i-(len-1)/2;
                    end = i+ (len/2);
                }
            }
            return s.substring(start, end+1);
        }
        
        private int expandAroundCircle(String s, int left, int right) {
            int R = right, L=left;
            while(L >=0 && R< s.length() && s.charAt(L) == s.charAt(R)) {
                L--;
                R++;
            }
            return R - L -1; 
        }

    //https://leetcode.com/problems/longest-palindromic-substring/discuss/151144/Bottom-up-DP-Logical-Thinking
    public String longestPalindromeDP(String s) {

        boolean state[][] = new boolean[s.length()][s.length()];

        for(int i=0; i<s.length(); i++){
            state[i][i] = true;
        }

        int maxLen = 0;
        int maxi = -1;

        for(int i=s.length()-1; i>=0; i--){
            for(int dist=1; dist<s.length()-i; dist++){
                int j = i+dist;
                state[i][j] = dist == 1 ? s.charAt(i) == s.charAt(j) : s.charAt(i) == s.charAt(j) && state[i+1][j-1];
                if(state[i][j] && maxLen < j-i+1){
                    maxLen = j-i+1;
                    maxi = i;
                }
            }
        }
        return s.substring(maxi, maxi+maxLen);
    }
}
