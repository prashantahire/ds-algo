package leetecode.string;

public class ValidateIpAddress {
    public String validIPAddress(String queryIP) {
        if(queryIP == null || queryIP.length() == 0 || queryIP.charAt(queryIP.length()-1) == '.' || queryIP.charAt(queryIP.length()-1) == ':')
            return "Neither";
        String ipv4[] = queryIP.split("\\.");
        String ipv6[] = queryIP.split(":");

        if(ipv4.length == 4) {
            return validateIpv4(ipv4);
        }
        if(ipv6.length == 8) {
            return validateIpv6(ipv6);
        }
        return "Neither";
    }

    private String validateIpv4(String ips[]){
        for(String ip : ips) {
            if(!validIp4(ip)){
                return "Neither";
            }
        }
        return "IPv4";
    }

    private boolean validIp4(String ip){
        if(ip==null || ip.length() == 0 || ip.length() > 3) {
            return false;
        }
        for(char ch: ip.toCharArray()){
            if(ch < '0' || ch > '9')
                return false;
        }
        if(ip.length()==3) {
            if(ip.charAt(0) == '0')
                return false;
            if(ip.charAt(0) == '2' && ip.charAt(1) > '5')
                return false;
            if(ip.charAt(0) == '2' && ip.charAt(1) == '5' && ip.charAt(2) > '5')
                return false;
        }
        if(ip.length()==2 && ip.charAt(0) == '0') {
            return false;
        }
        return true;

    }

    private String validateIpv6(String ips[]){

        for(String ip : ips) {
            if(!validIp6(ip)){
                return "Neither";
            }
        }
        return "IPv6";
    }

    private boolean validIp6(String ip){
        if(ip==null || ip.length() == 0 || ip.length() > 4) {
            return false;
        }
        for(char ch: ip.toCharArray()) {
            if((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch<= 'F'))
                continue;
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ValidateIpAddress v = new ValidateIpAddress();
        System.out.println(v.validIPAddress(":2001:0db8:85a3:0:0:8A2E:0370:7334"));
    }
}
