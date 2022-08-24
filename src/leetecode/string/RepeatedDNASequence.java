package leetecode.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatedDNASequence {

    public static void main(String ...args){
        RepeatedDNASequence rds = new RepeatedDNASequence();
        System.out.println(rds.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(rds.findRepeatedDnaSequences("AAAAAAAAAAA"));
    }
    public List<String> findRepeatedDnaSequences(String s) {
        if(s == null || s.equals("") || s.length() < 10)
            return null;
        Set<String> ans = new HashSet<>();
        Set<String> set = new HashSet<>();
        for(int i=0; i<s.length()-9; i++){
            String subStr = s.substring(i, i+10);
            if(set.contains(subStr)){
                ans.add(subStr);
            }else {
                set.add(subStr);
            }
        }
        return new ArrayList<>(ans);
    }
}
