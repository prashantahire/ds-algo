package leetecode.string;

public class IndexOf {
    
    public static void main(String ...args) {
        IndexOf io = new IndexOf();
        System.out.println(io.strStr("hello", "ll"));
    }
    public int strStr(String haystack, String needle) {
        if(haystack == null)
            return 0;
        if(needle == null || needle.isEmpty()) 
            return 0;
        if(haystack.length() < needle.length())
            return -1;
        
        for(int i=0; i<haystack.length(); i++) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                int k = i;
                for(int j=0; j<needle.length() && k<haystack.length() ; j++) {
                    if(haystack.charAt(k) != needle.charAt(j)) {
                        break;
                    }
                    k++;
                }
                if(k-i == needle.length())
                    return i;
            }
        }
        return -1;
    }
}
