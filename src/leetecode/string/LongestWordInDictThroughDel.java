package leetecode.string;

import java.util.*;
public class LongestWordInDictThroughDel {
    int maxLen = 0;
    List<String> ans = new ArrayList<>();
    //TIme : 2^n
    // Space: 26^26
    public String findLongestWord(String s, List<String> dictionary) {
        Trie root = buildTree(dictionary);
        dfs(0, s, root);
        if(ans.size()==0)
            return "";
        if(ans.size()==1)
            return ans.get(0);
        Collections.sort(ans);
        return ans.get(0);
    }

    private void dfs(int i, String s, Trie root) {

        if(i >= s.length()){
            if(root.isEow && root.word.length() >= maxLen){
                if(root.word.length() > maxLen){
                    ans.clear();
                    maxLen = root.word.length();
                }
                ans.add(root.word);
            }
            return;
        }
        int idx = s.charAt(i)-'a';
        if(root.childrens[idx] != null){
            dfs(i+1, s, root.childrens[idx]);
        }
        dfs(i+1, s, root);

    }
    private Trie buildTree(List<String> ds){
        Trie root = new Trie();
        for(String s: ds){
            Trie temp = root;
            for(char ch: s.toCharArray()){
                int idx = ch-'a';
                if(temp.childrens[idx] == null){
                    temp.childrens[idx] = new Trie();
                }
                temp = temp.childrens[idx];
            }
            temp.isEow = true;
            temp.word = s;
        }
        return root;
    }

    class Trie {
        Trie childrens[];
        boolean isEow;
        String word;
        public Trie(){
            childrens = new Trie[26];
        }
    }

    // TIme(m*n)
    // SPace constant
    public String findLongestWord2(String s, List<String> dictionary) {

        Collections.sort(dictionary, (s1, s2) -> {
            if(s1.length() != s2.length())
                return s2.length()-s1.length();
            return s1.compareTo(s2);
        });

        for(String str: dictionary){
            if(isSubSeq(s, str))
                return str;
        }
        return "";
    }

    private boolean isSubSeq(String s1, String s2){
        int j=0;
        for(int i=0; i<s1.length() && j<s2.length(); i++){
            if(s1.charAt(i) == s2.charAt(j)) j++;
        }
        return j == s2.length();
    }
}
