

package leetecode.string;


public class CountAndSay {

    public static void main(String... args) {
        CountAndSay cas = new CountAndSay();
        System.out.println(cas.countAndSay2(5));
    }

    public String countAndSay(int n) {

        String s = "1";
        if (n <= 0)
            return "";
        for (int i = 2; i <= n; i++) {
            int j = 0;
            StringBuilder sb = new StringBuilder();
            while (j < s.length()) {
                char prevChar = s.charAt(j);
                int cnt = 0;
                while (j < s.length() && s.charAt(j) == prevChar) {
                    j++;
                    cnt++;
                }
                    sb.append(cnt+""+prevChar);
            }
            s = sb.toString();
        }
        return s;
    }
    
    public String countAndSay2(int n) {

        String s = "1";
        if (n <= 0)
            return "";
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int j=0, cnt = 1;
            while (j < s.length()-1) {
                if(s.charAt(j) != s.charAt(j+1)) {
                    sb.append(cnt+""+s.charAt(j));
                    cnt=0;
                    
                }
                cnt++;
                j++;
            }
            sb.append(cnt+""+s.charAt(j));
            s = sb.toString();
        }
        return s;
    }
}
