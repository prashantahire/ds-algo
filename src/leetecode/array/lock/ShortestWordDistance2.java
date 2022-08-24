package leetecode.array.lock;

import java.util.*;

/**
 * This is a follow up of Shortest Word Distance. The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters. How would you optimize it?
 *
 * Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.
 *
 * For example,
 *
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Given word1 = "coding”, word2 = "practice”, return 3. Given word1 = "makes", word2 = "coding", return 1.
 *
 * Note
 *
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class ShortestWordDistance2 {
    public static void main(String ...args){
        List<String> l1 = Arrays.asList("practice", "makes", "perfect", "coding", "makes");
        WordDistance swd = new WordDistance(l1);
        System.out.println(swd.findDistance( "coding", "practice"));
        System.out.println(swd.findDistance( "coding", "makes"));
    }
}

class WordDistance {

    private Map<String, List<Integer>> map;

    public WordDistance(List<String> words){
        List<Integer> l;
        map = new HashMap<>();
        for(int i=0; i<words.size(); i++){
            if(!map.containsKey(words.get(i))) {
                map.put(words.get(i), new ArrayList<>());
            }
            map.get(words.get(i)).add(i);
        }
    }

    public int findDistance(String w1, String w2){
        List<Integer> l1 = map.get(w1);
        List<Integer> l2 = map.get(w2);
        int dist = Integer.MAX_VALUE;
        for(int m : l1)
            for(int n: l2)
                dist = Math.min(dist, Math.abs(m-n));
        return dist;
    }
}
