package leetecode.string;

public class LenOfLastWord {
    
    public static void main(String ...args) {
        LenOfLastWord lw = new LenOfLastWord();
        System.out.println(lw.lengthOfLastWord("a "));
    }
    public int lengthOfLastWord(String s) {
        int len = 0; 
        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i) == ' ' && len > 0)
                break;
            else if(s.charAt(i) == ' ')
                continue;
            len++;
        }
        return len;
    }
}
