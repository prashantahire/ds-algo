package leetecode.dynaprog;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public static void main(String ...args){
        String s = "leetcode";
        List<String> l = Arrays.asList("leet","code");
        System.out.println(new WordBreak().wordBreakTopDown(s, l));
    }
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);
        return wordBreakRec(0, s, set);
    }

    private boolean wordBreakRec(int i, String s, Set<String> set){
        if(i>=s.length())
            return true;
        for(int j=i; j<s.length(); j++){
            String temp = s.substring(i, j+1);
            if(set.contains(temp)){
                if(wordBreakRec(j+1, s, set))
                    return true;
            }
        }
        return false;
    }

    public boolean wordBreakBottomUp(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);
        int a[] = new int[s.length()];
        Arrays.fill(a, -1);
        return wordBreakDPBottomUpRec(0, s, set,a);
    }

    private boolean wordBreakDPBottomUpRec(int i, String s, Set<String> set, int a[]){
        if(i>=s.length())
            return true;
        if(a[i] != -1){
            return a[i] == 1;
        }
        for(int j=i; j<s.length(); j++){
            String tmp = s.substring(i, j+1);
            if(set.contains(tmp)){
                boolean res = wordBreakDPBottomUpRec(j+1, s, set, a);
                if(res){
                    a[i] = 1;
                    return true;
                }else
                    a[i] = 0;
            }
        }
        return false;
    }

    public boolean wordBreakTopDown(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean valword[] = new boolean[s.length()+1];
        valword[0] = true;
        for(int i=1; i<s.length(); i++){
            for(int j=i; j<=s.length(); j++){
                if(valword[i-1] && set.contains(s.substring(i-1, j))){
                    valword[j] = true;
                    break;
                }
            }
        }
        return valword[s.length()];

    }

    public boolean wordBreak2(String s, List<String> wordDict) {

        Set<String> set = new HashSet<>(wordDict);
        int len = s.length();
        boolean a[] = new boolean[len+1];
        a[0] = true;
        for(int i=1; i<=len; i++){
            for(int j=0; j<i; j++){
                if(a[j] && set.contains(s.substring(j, i))){
                    a[i] = true;
                    break;
                }
            }
        }
        return a[len];
    }

}
