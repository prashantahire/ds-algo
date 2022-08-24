package leetecode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String ...args){
        System.out.println(new PalindromePartitioning().partition("efe"));
    }
    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();
        if(s == null || s.length() == 0)
            return ans;

        partitionRec(s, 0, new ArrayList<>(), ans, palindromeMatrix(s));
        return ans;
    }

    private void partitionRec(String s, int i, List<String> partitions, List<List<String>> ans, int a[][]){
        if(i == s.length()){
            ans.add(new ArrayList<>(partitions));
            return;
        }

        for(int j=i; j<s.length(); j++){
            if(a[i][j] == 1) {
                String subStr = s.substring(i, j + 1);
                partitions.add(subStr);
                partitionRec(s, j + 1, partitions, ans, a);
                partitions.remove(partitions.size() - 1);
            }
        }
    }

    private int[][] palindromeMatrix(String s){
        int len = s.length();
        int a[][] = new int[len][len];
        for(int i=0; i<len; i++){
            for(int j=i; j<len; j++){
                if(isPalindrome(s, i, j))
                    a[i][j] = 1;
            }
        }
        return a;
    }
    private boolean isPalindrome(String s, int i, int j){
        for(int k=i, l=j; k<l; k++, l--)
            if(s.charAt(k) != s.charAt(l))
                return false;
        return true;
    }
}
