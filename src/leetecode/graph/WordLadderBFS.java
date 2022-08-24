package leetecode.graph;

import java.util.*;

public class WordLadderBFS {

    public static void main(String ...args){
        List<String> w= Arrays.asList("hot","dot","dog","lot","log","cog");
        List<String> w1= Arrays.asList("a", "b", "c");
        List<String> w2= Arrays.asList("ted","tex","red","tax","tad","den","rex","pee");

        System.out.println(new WordLadderBFS().ladderLength("hit", "cog", w));
        System.out.println(new WordLadderBFS().ladderLength("a", "c", w1));
        System.out.println(new WordLadderBFS().ladderLength2("red", "tax", w2));
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graph = createGraph(beginWord, wordList);
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        q.offer(null);
        int level = 0;
        String node;
        List<String> visited = new ArrayList<>();
        while (!q.isEmpty()){
            node = q.poll();
            if(node == null){
                level++;
                if(!q.isEmpty()){
                    q.offer(null);
                }
                continue;
            }
            List<String> tmp = graph.get(node);
            if(tmp == null)
                continue;
            for(String w : tmp){
                if(w.equals(endWord))
                    return level+2;
                if(!visited.contains(w)) {
                    visited.add(w);
                    q.offer(w);
                }
            }
        }
        return 0;
    }
    private Map<String, List<String>> createGraph(String beginWord, List<String> wordList){
        Map<String, List<String>> map = new HashMap<>();
        String node;
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int nodes = wordList.contains(beginWord) ? wordList.size():wordList.size()+1;
        List<String> added = new ArrayList<>();
        while (!q.isEmpty()){
            node = q.poll();
            List<String> tempL = findAdjacencyList(node, wordList, q, added);
            if(tempL.size() > 0)
                map.put(node, tempL);
            if(map.size() == nodes)
                break;
        }
        return map;
    }
    private List<String> findAdjacencyList(String word, List<String> list, Queue<String> q, List<String> added){
        List<String> l = new ArrayList<>();
        for(int i=0; i<list.size(); i++){
            int cnt = 0;
            String w = list.get(i);
            if(word.equals(w))
                continue;
            for(int j=0; j<w.length(); j++){
                if(cnt > 1)
                    break;
                if(w.charAt(j) != word.charAt(j))
                    cnt++;
            }
            if(cnt<=1) {
                l.add(w);
                if(!added.contains(w)){
                    q.offer(w);
                    added.add(w);
                }
            }
        }
        return l;
    }

    //Simplified bfs
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || endWord == null || wordList == null || wordList.isEmpty())
            return 0;
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord))
            return 0;
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(beginWord);
        q.offer(null);
        visited.add(beginWord);
        int level =1;
        while(!q.isEmpty()){
            String node = q.poll();
            if(node == null){
                level++;
                if(!q.isEmpty())
                    q.offer(null);
                continue;
            }
            for(String adjWord : getNeighbours(node, wordSet)){
                if(adjWord.equals(endWord))
                    return level+1;
                if(!visited.contains(adjWord)) {
                    q.offer(adjWord);
                    visited.add(adjWord);
                }
            }
        }
        return 0;
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
