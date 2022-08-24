package leetecode.graph;

import java.util.*;

public class WordLadder2BFS {
    public static void main(String ...args){
        List<String> w= Arrays.asList("hot","dot","dog","lot","log");
        List<String> w1= Arrays.asList("a", "b", "c");
        List<String> w2= Arrays.asList("ted","tex","red","tax","tad","den","rex","pee");
        List<String> w3= Arrays.asList("kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob");
        System.out.println(new WordLadder2BFS().findLaddersFinal("cet", "ism", w3));
        //System.out.println(new WordLadder2BFS().findLadders("a", "c", w1));
        //System.out.println(new WordLadder2BFS().findLadders("red", "tax", w2));
    }
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> ans = new ArrayList<>();
        if(beginWord == null || endWord == null || wordList == null || wordList.isEmpty())
            return ans;
        List<String> path =  new ArrayList<>();
        Map<String, List<String>> parentMap = new HashMap<>();

        for(String w : wordList)
            parentMap.put(w, new ArrayList<>());
        parentMap.put(beginWord, new ArrayList<>());

        if(!bfs(beginWord, endWord, wordList, parentMap))
            return ans;

        dfs(endWord, beginWord, parentMap, path, ans);
        return ans;
    }

    private void dfs(String currentWord, String beginWord,
                     Map<String, List<String>> parentMap,
                     List<String> path, List<List<String>> ans){
        if(currentWord.equals(beginWord)){
            List<String> temp = new ArrayList<>(path);
            temp.add(currentWord);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }

        if(parentMap.get(currentWord).isEmpty()) return;

        for(String parent:parentMap.get(currentWord)){
            path.add(currentWord);
            dfs(parent, beginWord, parentMap, path, ans);
            path.remove(path.size()-1);
        }

    }

    private boolean bfs(String beginWord, String endWord, List<String> wordList, Map<String, List<String>> parentMap){
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();

        Map<String, Integer> levelMap = new HashMap<>();

        levelMap.put(beginWord, 0);
        q.offer(beginWord);

        boolean found = false;

        while(!q.isEmpty()){
            int noOfNode=q.size();
            for(int i=0; i<noOfNode; i++){
                String node = q.poll();
                List<String> children = getAdjacencyList(node, wordSet);

                for(String adjNode: children){
                    if(adjNode.equals(endWord)) {
                        found = true;
                    }
                    Integer adjLvl = levelMap.get(adjNode);
                    if(adjLvl == null){
                        parentMap.get(adjNode).add(node);
                        levelMap.put(adjNode, levelMap.get(node)+1);
                        q.offer(adjNode);
                    }else{
                        if(adjLvl == levelMap.get(node)+1)
                            parentMap.get(adjNode).add(node);
                    }

                }
            }
            if(found)
                break;
        }
        return found;
    }
    private List<String> getAdjacencyList(String node, Set<String> wordSet){

        List<String> list = new ArrayList<>();
        char nodeChars[] = node.toCharArray();
        for(int i=0; i<node.length(); i++){
            char origChar = nodeChars[i];
            for(char ch='a'; ch<='z'; ch++){
                if(ch == nodeChars[i]) continue;
                char tmp = nodeChars[i];
                nodeChars[i] = (char)ch;
                String newNode = new String(nodeChars);
                if(wordSet.contains(newNode)){
                    list.add(newNode);
                }
                nodeChars[i] = (char)tmp;
            }
            nodeChars[i] = origChar;
        }
        return list;
    }




    public List<List<String>> findLaddersFinal(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        if(beginWord == null || endWord == null || wordList == null || wordList.isEmpty())
            return ans;
        List<String> path =  new ArrayList<>();
        Map<String, List<String>> parentMap = new HashMap<>();

        for(String w : wordList)
            parentMap.put(w, new ArrayList<>());
        parentMap.put(beginWord, new ArrayList<>());
        int minLevel = bfsFinal(beginWord, endWord, wordList, parentMap);
        if(minLevel == -1)
            return ans;

        //begin dfs
        List<String> list = new ArrayList<>();
        list.add(beginWord);
        dfsFinal(beginWord, endWord, parentMap, list, ans, 1, minLevel);
        return ans;
    }

    private int bfsFinal(String beginWord, String endWord, List<String> wordList, Map<String, List<String>> parentMap){

        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        int level = 1;
        int targetLevel = -1;
        boolean found = false;

        queue.add(beginWord);
        queue.add(null);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        while (!queue.isEmpty()){
            String word = queue.poll();
            if(word == null){
                if(!queue.isEmpty())
                    queue.offer(null);
                level++;
             if(targetLevel !=-1 && targetLevel<level)
                 break;
             continue;
            }
            List<String> adjList = getAdjacencyList(word, wordSet);
            parentMap.put(word, adjList);
            for(String adjWord : adjList){
                if(!visited.contains(adjWord)){
                    visited.add(adjWord);
                    queue.offer(adjWord);
                }
                if(adjWord.equals(endWord)){
                    found = true;
                    targetLevel = level;
                }
            }
        }
        return found ? level : targetLevel;
    }

    private void dfsFinal(String currentWord, String endWord,
                     Map<String, List<String>> parentMap,
                     List<String> path, List<List<String>> ans, int level, int minLvl) {
        if(currentWord.equals(endWord)){
            ans.add(new ArrayList<>(path));
        }
        if(level >= minLvl)
            return;
        for(String adjWord : parentMap.get(currentWord)){
            if(path.contains(adjWord))
                continue;
                path.add(adjWord);
                dfsFinal(adjWord, endWord, parentMap, path, ans, level+1, minLvl);
                path.remove(path.size()-1);
        }
    }
}
