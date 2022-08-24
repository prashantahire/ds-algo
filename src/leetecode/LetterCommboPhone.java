

package leetecode;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LetterCommboPhone {

    Map<Character, String> map = new HashMap<>();

    public LetterCommboPhone() {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

    }

    public static void main(String... args) {
        LetterCommboPhone lp = new LetterCommboPhone();
        System.out.println(lp.letterCombinations("23"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.trim().equals("")) {
            return list;
        }
        StringBuilder sb = new StringBuilder();
        buildCombinations(0, digits, list, sb);
        return list;
    }

    public void buildCombinations(int i, String d, List<String> list, StringBuilder sb) {
        if (i == d.length()) {
            list.add(sb.toString());
            return;
        }
        String dchars = map.get(d.charAt(i));
        for (int j = 0; j < dchars.length(); j++) {
            StringBuilder osb = new StringBuilder(sb.toString());
            buildCombinations(i + 1, d, list, osb.append(dchars.charAt(j)));
        }
    }
}
