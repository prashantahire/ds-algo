package leetecode.dynaprog;

public class DecodeWays {

    public static void main(String ...args){
        System.out.println(new DecodeWays().numDecodings("122621"));
    }
    public int numDecodings(String s) {
        if(s.charAt(0) == '0')
            return 0;
        return numDecodingsDp(s);
        //return numDecodingsBt(0, s, "");
    }

    public int numDecodingsBt(int i, String ip, String s){
        if(!s.equals("") && (s.charAt(0) == '0'||Integer.parseInt(s) > 26|| Integer.parseInt(s)<=0))
            return 0;
        if(i>=ip.length()){
                return 1;
        }
        return numDecodingsBt(i+1, ip, ip.substring(i, i+1))
                +  (i < ip.length()-1 ? numDecodingsBt(i+2, ip, ip.substring(i, i+2)):0);
    }

    public int numDecodingsDp(String s){
        int a[]=new int[s.length()+1];
        a[s.length()] = 1;
        a[s.length()-1] = s.charAt(s.length()-1) == '0' ? 0 : 1;
        for(int i=s.length()-2; i>=0; i--){
            char c1 = s.charAt(i);
            if(c1 != '0'){
                a[i] += a[i+1];
            }
            char c2 = s.charAt(i+1);
            if(c1 == '1' || (c1=='2' && c2 <='6')){
                a[i]+=a[i+2];
            }
        }
        return a[0];
    }

    public int numDecodingsDp2(String s){
        int a[]=new int[s.length()+1];
        a[0] = 1;
        a[1] = s.charAt(0) =='0'? 0: 1;

        for(int i=2; i<=s.length(); i++){
            char c1 = s.charAt(i-1);
            if(c1 != '0')
                a[i]+=a[i-1];
            char c2=s.charAt(i-2);
            if(c2=='1' || (c2=='2' && c1<='6'))
                a[i]+=a[i-2];
        }
        return a[s.length()];
    }
}
