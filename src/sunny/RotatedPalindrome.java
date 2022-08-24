package sunny;

public class RotatedPalindrome {
    
    public static void main(String ...args) {
        System.out.println(isRotatedPalindrome("darra"));
        System.out.println(isRotatedPalindrome("cbaab"));
        System.out.println(isRotatedPalindrome("prashant"));
    }
    public static boolean isRotatedPalindrome(String s) {
        String s1 = s+s;
        for(int i=0; i<s.length();i++) {
            if(isPalindrome(s1.substring(i, i+s.length())))
                return true;
        }
        return false;
    }
    private static boolean isPalindrome(String s) {
        int i=0, j=s.length()-1;
        while(i<j){
            if(s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
