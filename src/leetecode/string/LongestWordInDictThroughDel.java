package leetecode.string;

import java.util.*;
public class LongestWordInDictThroughDel {
    int maxLen = 0;
    List<String> ans = new ArrayList<>();
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
}
