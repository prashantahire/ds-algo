package leetecode.string;

public class ReverseWords {
    public String reverseWords(String s) {
        StringBuilder s1= new StringBuilder();
        s=s.trim();
        if(s== null || s.equals(""))
            return s1.toString();
        int j = s.length();
        boolean wordFound = false;
        for(int i=s.length()-1; i>=0;i--){
            if(s.charAt(i) == ' ' && !wordFound){
                wordFound = true;
                s1.append(s.substring(i+1, j)+" ");
                j=i;
            }else if(s.charAt(i) == ' '){
                j--;
            }else{
                wordFound = false;

            }
        }
        s1.append(s.substring(0, j));
        return s1.toString();
    }
}
