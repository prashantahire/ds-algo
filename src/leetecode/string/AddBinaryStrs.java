

package leetecode.string;


public class AddBinaryStrs {
    public static void main(String... args) {
        AddBinaryStrs ab = new AddBinaryStrs();
        System.out.println(ab.addBinary("10", "1"));
        System.out.println(ab.addBinary("101111", "10"));
        System.out.println(ab.addBinary2("10", "1"));
        System.out.println(ab.addBinary2("101111", "10"));

    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        boolean isCary = false;
        while (i >= 0 && j >= 0) {
            if (a.charAt(i) == '1' && b.charAt(j) == '1' && isCary) {
                sb.insert(0, '1');
                isCary = true;
            }
            else if (a.charAt(i) == '1' && b.charAt(j) == '1' && !isCary) {
                sb.insert(0, '0');
                isCary = true;
            }
            else if (a.charAt(i) == '0' && b.charAt(j) == '0' && isCary) {
                sb.insert(0, '1');
                isCary = false;
            }
            else if (a.charAt(i) == '0' && b.charAt(j) == '0' && !isCary) {
                sb.insert(0, '0');
                isCary = false;
            }
            else if (isCary) {
                sb.insert(0, '0');
                isCary = true;
            }
            else {
                sb.insert(0, '1');
                isCary = false;
            }
            i--;
            j--;
        }
        while (i >= 0) {
            if (a.charAt(i) == '1' && isCary) {
                sb.insert(0, '0');
                isCary = true;
            }
            else if (a.charAt(i) == '0' && isCary) {
                sb.insert(0, '1');
                isCary = false;
            }
            else {
                sb.insert(0, a.charAt(i));
            }
            i--;
        }
        while (j >= 0) {
            if (b.charAt(j) == '1' && isCary) {
                sb.insert(0, '0');
                isCary = true;
            }
            else if (b.charAt(j) == '0' && isCary) {
                sb.insert(0, '1');
                isCary = false;
            }
            else {
                sb.insert(0, b.charAt(j));
            }
            j--;
        }
        if (isCary)
            sb.insert(0, '1');
        return sb.toString();
    }

    public String addBinary2(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        StringBuilder sb = new StringBuilder();
        int cary = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0)
                cary += a.charAt(i) - '0';
            if (j >= 0)
                cary += b.charAt(j) - '0';
            sb.insert(0, cary%2);
            cary = cary/2;
            i--;
            j--;
        }
        if(cary != 0)
            sb.insert(0, 1);
        return sb.toString();
    }
}
