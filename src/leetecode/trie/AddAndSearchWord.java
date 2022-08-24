package leetecode.trie;

public class AddAndSearchWord {
    public static void main(String... args) {
        WordDictionary wd = new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
//        System.out.println(wd.search("pad"));
//        System.out.println(wd.search("bad"));
//        System.out.println(wd.search(".ad"));
//        System.out.println(wd.search("b.."));

        WordDictionary wd2 = new WordDictionary();
        wd2.addWord("ran");
        wd2.addWord("rune");
        wd2.addWord("runner");
        wd2.addWord("runs");
        wd2.addWord("add");
        wd2.addWord("adds");
        wd2.addWord("addder");
        wd2.addWord("adddee");
//        wd2.addWord("at");
//        wd2.addWord("and");
//        wd2.addWord("an");
//        wd2.addWord("add");
//        wd2.addWord("a");
        System.out.println(wd2.search("add."));
        System.out.println(wd2.search(".a"));
//        wd2.addWord("bat");
//        System.out.println(wd.search("aa"));
        System.out.println(wd2.search(".at"));
        System.out.println(wd2.search("a."));

    }
}


class WordDictionary {

    private WordDictionary children[];
    boolean isEndOfWord;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        children = new WordDictionary[26];
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        WordDictionary temp = this;
        for (int i = 0; i < word.length(); i++) {
            int charIdx = word.charAt(i) - 'a';
            if (temp.children[charIdx] == null) {
                temp.children[charIdx] = new WordDictionary();
            }
            temp = temp.children[charIdx];
        }
        temp.isEndOfWord = true;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return searchRec(word, 0, this);
    }

    private boolean searchRec(String s, int i, WordDictionary wd) {
        if (i >= s.length())
            return wd.isEndOfWord;
        boolean res = false;
        if (s.charAt(i) == '.') {
            for (int j = 0; j < 26; j++) {
                if (wd.children[j] != null && searchRec(s, i + 1, wd.children[j]))
                    return true;
            }
        } else {
            int charIdx = s.charAt(i) - 'a';
            res = wd.children[charIdx] != null ? searchRec(s, i + 1, wd.children[charIdx]) : false;
        }
        return res;
    }
}