

package leetecode.hashmap;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class GroupAnagrams {
    
    public static void main(String ...args) {
        String a[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams ga = new GroupAnagrams();
        System.out.println(ga.groupAnagrams(a));
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ansMap = new HashMap<>();
        for (String s : strs) {
            int a[] = new int[26];
            for (char ch : s.toCharArray()) {
                a[ch - 'a']++;
            }
            StringBuilder keyb = new StringBuilder();
            for (int i : a)
                keyb.append(i + "#");
            String key = keyb.toString();

            if (ansMap.containsKey(key))
                ansMap.get(key).add(s);
            else {
                List<String> list = new ArrayList<>();
                list.add(s);
                ansMap.put(key, list);
            }
        }
        final List<List<String>> ans = new ArrayList<>();
        ansMap.entrySet().stream().forEach(ks -> ans.add(ks.getValue()));
        return ans;
    }
}
