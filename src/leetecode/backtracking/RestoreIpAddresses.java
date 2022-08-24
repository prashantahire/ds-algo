package leetecode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIpAddresses {

    public static void main(String ...args){
        System.out.println(new RestoreIpAddresses().restoreIpAddresses("010010"));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ipList = new ArrayList<>();
        if(s == null || s.equals(""))
            return ipList;

        restoreIpBtRef(0, 0, s, "", ipList);
        return ipList;
    }

    public void restoreIpBt(int i, int byteCnt, String s, String ip, List<String> ipList){
        if(i >= s.length() && byteCnt == 4){
            ipList.add(ip);
            return;
        }else if(byteCnt == 4)
            return;
        if(i+1 <= s.length())
            restoreIpBt(i+1, byteCnt+1, s, ip+s.substring(i, i+1)+ (byteCnt == 3? "":"."), ipList);
        if(i+2 <= s.length() && s.substring(i, i+2).charAt(0) != '0') {
            String temp = s.substring(i, i+2);
            if(temp.charAt(0) != '0')
                restoreIpBt(i + 2, byteCnt + 1, s, ip + temp + (byteCnt == 3 ? "" : "."), ipList);
        }
        if(i+3 <= s.length()){
            String temp = s.substring(i, i+3);
            if(temp.charAt(0) != '0' && Integer.parseInt(s.substring(i, i+3)) <=255)
                restoreIpBt(i+3, byteCnt+1, s,ip+temp+(byteCnt == 3? "":"."), ipList);

        }
    }


    public void restoreIpBtRef(int i, int byteCnt, String s, String ip, List<String> ipList){
        if(byteCnt == 4){
            if(i>=s.length())
                ipList.add(ip);
            return;
        }
        int num=0;
        for(int j=1; j<=3; j++){
            if(i+j<=s.length()){
                num=num*10 + (s.charAt(i+j-1)-'0');
                if(s.charAt(i)=='0' &&j>1 || num>255)
                    continue;
                String newIp = s.substring(i, i+j) + (byteCnt == 3? "":".");
                restoreIpBt(i+j, byteCnt+1, s,ip+newIp, ipList);
            }
        }
    }
}
