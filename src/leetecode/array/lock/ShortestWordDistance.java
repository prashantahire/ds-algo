package leetecode.array.lock;


//https://tonycao.gitbooks.io/leetcode-locked/content/LeetCode%20Locked/c1.4.html

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 *
 * For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 *
 * Given word1 = "coding", word2 = "practice", return 3. Given word1 = "makes", word2 = "coding", return 1.
 */
public class ShortestWordDistance {

    public static void main(String ...args){
        List<String> l1 = Arrays.asList("practice", "makes", "perfect", "coding", "makes");
        ShortestWordDistance swd = new ShortestWordDistance();
        System.out.println(swd.shortestDistance(l1, "coding", "practice"));
        System.out.println(swd.shortestDistance(l1, "coding", "makes"));
    }
    public int shortestDistance(List<String> words, String w1, String w2){

        int idx1=-1, idx2=-1;
        int dist= Integer.MAX_VALUE;
        for(int i=0;i<words.size();i++){
            if(words.get(i).equals(w1))
                idx1 = i;
            if(words.get(i).equals(w2))
                idx2 = i;
            if(idx1 != -1 && idx2 != -1){
                dist = Math.min(dist, Math.abs(idx1-idx2));
            }
        }
        return dist;
    }
}
