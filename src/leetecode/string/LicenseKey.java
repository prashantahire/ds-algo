package leetecode.string;

public class LicenseKey {
    public String licenseKeyFormatting(String s, int k) {
        String s1 = s.toUpperCase().replace("-", "");
        StringBuilder sb = new StringBuilder();
        int i=s1.length()-1;
        int j=0;
        while(i>=0) {
            sb.append(s1.charAt(i));
            j++;
            if(j%k==0 && i !=0){
                sb.append('-');
            }
            i--;
        }
        return sb.reverse().toString();
    }
}
