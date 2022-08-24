package leetecode.string;

public class RepeatedSubStringPattern {
    public boolean repeatedSubstringPattern(String s) {
        for(int i=1; i<s.length()/2+1; i++){
            String subStr = s.substring(0, i);
            int j=i;
            boolean isVal = true;
            while(j<s.length()) {
                if(j+subStr.length() > s.length() || !subStr.equals(s.substring(j, j+subStr.length()))){
                    isVal = false;
                    break;
                }
                j+=subStr.length();
            }
            if(isVal)
                return isVal;
        }
        return false;
    }

    public boolean repeatedSubstringPattern2(String s) {
        String s2 = s+s;
        return s2.substring(1, s2.length()-1).contains(s);
    }
}
