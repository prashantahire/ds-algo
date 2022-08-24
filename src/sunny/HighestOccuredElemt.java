package sunny;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HighestOccuredElemt {
    
    public static void main(String ...args) {
        System.out.println(highestOccuredChar("Prah  anth"));
        System.out.println(highestOccuredChar("prashanthh"));
        int a[] = {5, 6, 2, 5, 1};
        System.out.println(highestOccuredElement(a));
        
        int a1[] = {-5, 6, 2, 5, 1, 45, -1, 34, 6, -1, 67, -1};
        System.out.println(highestOccuredElement(a1));

    }
    public static char highestOccuredChar(String s) {
        if(s== null || s.equals(""))
            return '-';
        s = s.toLowerCase().trim();
        Map<Character, Integer> map = new HashMap<>();
        for(char ch:s.toCharArray()) {
            if(ch == ' ')
                continue;
            if(map.containsKey(ch)) 
                map.put(ch, map.get(ch)+1);
            else
                map.put(ch, 1);
        }
        int maxCnt = 0;
        char maxOccChar='-';
        for(Entry<Character, Integer> e:map.entrySet()) {
            if(maxCnt < e.getValue()) {
                maxCnt = e.getValue();
                maxOccChar = e.getKey();
            }
        }
        return maxOccChar;
    }
    
    public static int highestOccuredElement(int a[]) {
        Arrays.sort(a);
        int maxCnt = 0;
        int maxOccEle = a[0];
        int eleCnt=1;
        int prevEle = a[0];
        for(int i=1;i<a.length;i++) {
            if(prevEle == a[i])
                eleCnt++;
            else {
                if(maxCnt < eleCnt) {
                    maxCnt = eleCnt;
                    maxOccEle = prevEle;
                }
                prevEle = a[i];
                eleCnt = 1;
            }
        }
        return maxOccEle;
    }
}
