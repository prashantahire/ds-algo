package leetecode.string;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class KeyboardRow {
    public String[] findWords(String[] words) {
        List<String> ans = new ArrayList<>();
        Set<Character> upper = "qwertyuiop".chars().mapToObj( c -> (char)c).collect(Collectors.toSet());
        Set<Character> middle = "asdfghjkl".chars().mapToObj(c -> (char)c).collect(Collectors.toSet());
        Set<Character> lower = "zxcvbnm".chars().mapToObj(c -> (char)c).collect(Collectors.toSet());
        for(String w: words){
            w=w.toLowerCase();
            if(upper.contains(w.charAt(0))){
                if(hasAllChars(w, upper)){
                    ans.add(w);
                }
            } else if(middle.contains(w.charAt(0))) {
                if(hasAllChars(w, middle)){
                    ans.add(w);
                }

            } else {
                if(hasAllChars(w, lower)){
                    ans.add(w);
                }
            }

        }
        return ans.toArray(new String[ans.size()]);
    }

    private boolean hasAllChars(String w, Set<Character> set){
        boolean hasAll = true;
        for(char ch: w.toCharArray()){
            if(!set.contains(ch))
                return false;
        }
        return true;
    }
}
