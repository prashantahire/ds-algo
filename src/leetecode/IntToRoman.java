

package leetecode;


import java.util.HashMap;
import java.util.Map;


public class IntToRoman {
    Map<Integer, String> map = new HashMap<>();

    public IntToRoman() {
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
        map.put(4, "IV");
        map.put(9, "IX");
        map.put(40, "XL");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(900, "CM");
    }

    public static void main(String... args) {
        IntToRoman ir = new IntToRoman();
        String s;
        System.out.println(ir.intToRoman(60));
    }

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        int pow = 0;
        while (num > 0) {
            int mod = num % 10;
            int numWithM = (int)(mod * Math.pow(10, pow));
            if (map.containsKey(numWithM)) {
                sb.insert(0, map.get(numWithM));
            }
            else {
                if (pow == 0) {
                    insertRomanChars(sb, numWithM > 5 ? numWithM - 5 : numWithM, 1);
                    if (numWithM > 5) {
                        sb.insert(0, map.get(5));
                    }
                }
                if (pow == 1) {
                    insertRomanChars(sb, numWithM > 50 ? numWithM - 50 : numWithM, 10);
                    if (numWithM > 50) {
                        sb.insert(0, map.get(50));
                    }
                }
                if (pow == 2) {
                    insertRomanChars(sb, numWithM > 500 ? numWithM - 500 : numWithM, 100);
                    if (numWithM > 500) {
                        sb.insert(0, map.get(500));
                    }
                }
                if (pow == 3) {
                    insertRomanChars(sb, numWithM, 1000);
                }
            }
            num = num / 10;
            pow++;
        }
        return sb.toString();
    }

    private void insertRomanChars(StringBuilder sb, int numWithM, int key) {
        while (numWithM > 0) {
            sb.insert(0, map.get(key));
            numWithM-=key;
        }
    }


    public String intToRomanBetter(int num) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<values.length; i++){
            while (num >= values[i]){
                sb.append(values[i]);
                num = num - values[i];
            }
        }
        return sb.toString();
    }
}
