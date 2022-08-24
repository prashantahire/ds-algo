package leetecode.string;

public class ValidPalindrome {
    public static void main(String ...args){
        System.out.println(new ValidPalindrome().isPalindrome("1b1"));
    }
    public boolean isPalindrome(String s) {
        int i=0, j=s.length()-1;
        while(i<j){
            if ((s.charAt(i) < 'a' || s.charAt(i) > 'z') && !Character.isDigit(s.charAt(i)))
            {i++;
            continue;
            }
            if(( s.charAt(j) < 'a' || s.charAt(j) > 'z') && !Character.isDigit(s.charAt(j))){
                j--;
                continue;
            }
            if(i< s.length() && j>=0 &&s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
