package sunny;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingChar {
    
    public static void main(String ...args) {
        FirstNonRepeatingChar fch = new FirstNonRepeatingChar();
        System.out.println(fch.noRepeatingChar("prashantpr"));
        System.out.println(fch.noRepeatingChar("aparnap"));
    }
    public char noRepeatingChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch:s.toCharArray()) {
            if(map.containsKey(ch))
                map.put(ch, map.get(ch)+1);
            else
                map.put(ch, 1);
        }
        for(char ch: s.toCharArray())
            if(map.get(ch) == 1)
                return ch;
        return '-';
    }
}
