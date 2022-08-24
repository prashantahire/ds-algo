package leetecode.string;

import java.util.Random;

//https://leetcode.com/problems/compare-version-numbers/
public class CompareVersionNumber {

    public static void main(String ...args){
        CompareVersionNumber cvn = new CompareVersionNumber();
        //System.out.println(CompareVersionNumber.compareVersion2("01", "1"));
        Random rando = new Random();
        for(int i=0; i<10; i++){
        System.out.println(rando.nextInt(1));}
    }
    public int compareVersion(String version1, String version2) {
        int len1 = version1.length();
        int len2 = version2.length();
        int i=0, j=0;
        while(i<len1 && j<len2){
            String t1 = "0";
            while(i<len1 && version1.charAt(i) != '.'){
                t1+=version1.charAt(i);
                i++;
            }
            String t2 = "0";
            while (j < len2 && version2.charAt(j) != '.'){
                t2+=version2.charAt(j);
                j++;
            }
            int ver1 = Integer.parseInt(t1);
            int ver2 = Integer.parseInt(t2);
            if(ver1 > ver2) return 1;
            if(ver1<ver2) return -1;
            i++;
            j++;
        }
        while (i<len1){
            if(version1.charAt(i) != '.' && version1.charAt(i) != '0')
                return 1;
            i++;
        }
        while(j<len2){
            if(version2.charAt(j) != '.' && version2.charAt(j) != '0')
                return -1;
            j++;
        }
        return 0;
    }

    //improved
    public int compareVersion2(String version1, String version2) {
        if (version1 == null || version2 == null) return 0;
        int v1 = 0, v2 = 0;
        int i = 0, j = 0;
        while(i < version1.length() || j < version2.length()) {
            while (i < version1.length() && version1.charAt(i) != '.') {
                v1 = v1*10+(version1.charAt(i)-'0');
                i++;
            }
            while (j < version2.length() && version2.charAt(j) != '.') {
                v2 = v2*10+(version2.charAt(j)-'0');
                j++;
            }
            if (v1 > v2) return 1;
            else if (v1 < v2) return -1;
            i++;
            j++;
            v1 = 0;
            v2 = 0;
        }
        return 0;
    }
}
