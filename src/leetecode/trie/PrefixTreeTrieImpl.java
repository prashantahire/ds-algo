package leetecode.trie;

public class PrefixTreeTrieImpl {
}
class Trie {

    private Trie[] children;
    private boolean isEndOdWord;
    /** Initialize your data structure here. */
    public Trie() {
        children = new Trie[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word == null || "".equals(word))
            return;
        Trie lastTrie = this;
        for(int i=0; i<word.length(); i++){
            int charIdx = word.charAt(i)-'a';
            if(lastTrie.children[charIdx] == null){
                lastTrie.children[charIdx] = new Trie();
            }
            lastTrie = lastTrie.children[charIdx];
        }
        lastTrie.isEndOdWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word == null || "".equals(word))
            return false;
        Trie temp = this;
        for(int i=0; i<word.length(); i++){
            int charIdx = word.charAt(i) - 'a';
            if(temp.children[charIdx] == null)
                return false;
            temp = temp.children[charIdx];
        }
        return temp.isEndOdWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix == null || "".equals(prefix))
            return false;
        Trie temp = this;
        for(int i=0; i<prefix.length(); i++){
            int charIdx = prefix.charAt(i) - 'a';
            if(temp.children[charIdx] == null)
                return false;
            temp = temp.children[charIdx];
        }
        return true;
    }
}