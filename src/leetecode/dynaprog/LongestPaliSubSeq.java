package leetecode.dynaprog;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestPaliSubSeq {
    public int longestPalindromeSubseq(String s) {
        return dfs(s, 0, "");
    }

    private int dfs(String s, int i, String sb) {
        if( i >= s.length()){
            return 0;
        }
        String sn = sb+s.charAt(i);
        int ans1 = dfs(s, i+1, sn);
        int ans2 = dfs(s, i+1, sb);
        int ans = Math.max(ans1, ans2);
        if(isPali(sn)){
            return Math.max(ans, sn.length());
        }
        return ans;
    }

    private boolean isPali(String sb){
        int i=0, j=sb.length()-1;
        while(i<=j){
            if(sb.charAt(i) != sb.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public int longestPalindromeSubseq2(String s) {
        return dfsDyn(s, 0, "", new HashMap<>());
    }
    private int dfsDyn(String s, int i, String sb, Map<String, Integer> map) {
        if( i >= s.length()){
            return 0;
        }
        String sn = sb+s.charAt(i);
        String key = sn+"#"+i;
        if(map.containsKey(key)){
            return map.get(key);
        }
        int ans1 = dfsDyn(s, i+1, sn, map);
        int ans2 = dfsDyn(s, i+1, sb, map);
        int ans = Math.max(ans1, ans2);
        if(isPali(sn)){
            ans = Math.max(ans, sn.length());
        }
        map.put(key, ans);
        return ans;
    }


    // working
    // TIme O(2^n)
    public int longestPalindromeSubseq3(String s) {
        return dfs(0, s.length()-1, s);
    }

    private int dfs(int l, int r, String s){
        if(l==r)
            return 1;
        if(l>r)
            return 0;
        if(s.charAt(l) == s.charAt(r)){
            return 2 + dfs(l+1, r-1, s);
        }
        return Math.max(dfs(l+1, r, s), dfs(l, r-1, s));
    }

    // Time O(n^2)
    //Space O(n^2)
    public int longestPalindromeSubseq4(String s) {
        int a[][] = new int[s.length()][s.length()];
        for(int b[] : a){
            Arrays.fill(b, -1);
        }
        return dfs(0, s.length()-1, s, a);
    }

    private int dfs(int l, int r, String s, int a[][]){
        if(l==r)
            return 1;
        if(l>r)
            return 0;
        if(a[l][r]!=-1)
            return a[l][r];
        int ans = s.charAt(l)==s.charAt(r) ? 2 + dfs(l+1, r-1, s, a) : Math.max(dfs(l+1, r, s, a), dfs(l, r-1, s, a));
        a[l][r] = ans;
        return ans;
    }
    public static void main(String[] args) {
        LongestPaliSubSeq ls = new LongestPaliSubSeq();
        int ans = ls.longestPalindromeSubseq3("asddsdbbbsda");
        System.out.println(ans);
    }
}
