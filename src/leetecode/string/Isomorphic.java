package leetecode.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/isomorphic-strings/
public class Isomorphic {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null || s.equals("") || t.equals(""))
            return true;
        Map<Character, Character> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
           if(map.containsKey(s.charAt(i))){
               if(map.get(s.charAt(i)) == t.charAt(i))
                   continue;
               else
                   return false;
           }else{
               if(!map.containsValue(t.charAt(i))){
                   map.put(s.charAt(i), t.charAt(i));
               }
               else
                return false;
               }
           }
        return true;
    }
    public static void main(String ...args){
        new Isomorphic().isIsomorphic2("egg", "add");
    }

    //Space and timeing improvement

    public boolean isIsomorphic2(String s, String t) {
        if (s == null || t == null || s.equals("") || t.equals(""))
            return true;
        int sa[] = new int[256];
        int ta[] = new int[256];
        Arrays.fill(sa, -1);
        Arrays.fill(ta, -1);
        for(int i=0;i<s.length();i++){
            int si = s.charAt(i)-0;
            int ti = t.charAt(i)-0;
            if(sa[si] !=-1){
                if(sa[si] == ti && ta[ti] == si)
                    continue;
                else
                    return false;
            }else{
                if(ta[ti] == -1){
                    sa[si] = ti;
                    ta[ti] = si;
                }else
                    return false;
            }
        }
        return true;
    }
}
