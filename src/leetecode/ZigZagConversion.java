

package leetecode;


public class ZigZagConversion {
    
    public static void main(String ...args) {
        ZigZagConversion za = new ZigZagConversion();
        System.out.println(za.convert("PAYPALISHIRING", 4));
    }
    public String convert(String s, int numRows) {
        if(s.length() ==1)
            return s;
        if(numRows ==1)
            return s;
        Character[][] a = new Character[numRows][s.length()];
        
        int r=0, c=0, i=0;
        
        while(i<s.length()) {
            while(i<s.length() && r<numRows-1) {
                a[r][c] = s.charAt(i);
                i++;
                r++;
            }
            while(i<s.length() && r>0) {
                a[r][c] = s.charAt(i);
                i++;
                r--;
                c++;
            }
        }
        StringBuilder sb = new StringBuilder();
        
        for(r=0; r<numRows; r++)
            for(c=0;c<s.length();c++)
            {
                if(a[r][c] != null)
                    sb.append(a[r][c]);
            }
        return sb.toString();
    }
}
