package leetecode.recursion;

public class ReverseStringRec {
    
    public static void main(String ...args) {
        ReverseStringRec rec = new ReverseStringRec();
        char[] ch = "Hellolpnm".toCharArray();
        rec.reverseString(ch);
        System.out.println(new String(ch));
    }
    public void reverseString(char[] s) {
        helper(s, 0, s.length-1);
    }
    
    public void helper(char[] s, int i, int j){
        if(i == s.length/2)
            return;
        char ch = s[i];
        s[i] = s[j];
        s[j] = ch;
        helper(s, i+1, j-1);
    }
}
