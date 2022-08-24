package leetecode.graph;

import java.util.*;

public class WordLadderBidirectionBFS {
    public static void main(String ...args){
        List<String> w= Arrays.asList("hot","dot","dog","lot","log","cog");
        List<String> w1= Arrays.asList("a", "b", "c");
        List<String> w2= Arrays.asList("ted","tex","red","tax","tad","den","rex","pee");

        System.out.println(new WordLadderBidirectionBFS().ladderLength("hit", "cog", w));
        System.out.println(new WordLadderBidirectionBFS().ladderLength("a", "c", w1));
        System.out.println(new WordLadderBidirectionBFS().ladderLength("red", "tax", w2));
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(beginWord == null || endWord == null || wordList == null || wordList.isEmpty())
            return 0;
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord))
            return 0;

        Queue<String> qBegin = new LinkedList<>();
        Queue<String> qEnd = new LinkedList<>();

        Set<String> visitedBeg = new HashSet<>();
        Set<String> visitedEnd = new HashSet<>();

        qBegin.offer(beginWord);
        visitedBeg.add(beginWord);

        qEnd.offer(endWord);
        visitedEnd.add(endWord);

        int level = 2;
        while (!qBegin.isEmpty() || !qEnd.isEmpty()){

            if(checkInterSection(qBegin, visitedBeg, visitedEnd, wordSet))
                return level;
            level++;
            if(checkInterSection(qEnd, visitedEnd, visitedBeg, wordSet))
                return level;
            level++;
        }
        return 0;
    }

    private boolean checkInterSection(Queue<String> q,
                                      Set<String> visitedFromThis,
                                      Set<String> visitedFromThat,
                                      Set<String> words){
        int noOfNodeInLevel = q.size();
        for(int i=0; i<noOfNodeInLevel; i++) {
            String node = q.poll();
            for (String adjWord : getNeighbours(node, words)) {
                if (visitedFromThat.contains(adjWord)) {
                    return true;
                }
                if (!visitedFromThis.contains(adjWord)) {
                    q.offer(adjWord);
                    visitedFromThis.add(adjWord);
                }
            }
        }
        return false;
    }
    private Set<String> getNeighbours(String node, Set<String> words){
        Set<String> nghbors = new HashSet<>();
        char[] wordArr = node.toCharArray();
        for(int i=0; i<node.length(); i++) {
            char originChar = wordArr[i];
            for (char ch = 'a'; ch <= 'z'; ch++) {
                wordArr[i] = (char)ch;
                String newWord = new String(wordArr);
                if(words.contains(newWord))
                    nghbors.add(newWord);
            }
            wordArr[i] = originChar;
        }
        nghbors.remove(node);
        return nghbors;
    }
}
