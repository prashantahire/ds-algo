package leetecode.string;

public class StringCompression {
    public int compress(char[] chars) {
        int i = 0, j = 0;
        int charCount = 0;
        int len = 0;
        while (j < chars.length) {
            if (chars[i] == chars[j]) {
                j++;
                charCount++;
                continue;
            }
            chars[len] = chars[j - 1];
            len++;
            if (charCount > 1) {
                len = addDigs(chars, charCount, len);
            }
            i = j;
            charCount = 0;
        }
        chars[len] = chars[j - 1];
        len++;

        if (charCount > 1) {
            len = addDigs(chars, charCount, len);
        }
        return len;
    }

    private int addDigs(char chars[], int charCount, int len) {
        int slen = len;
        while (charCount > 0) {
            int rem = charCount % 10;
            charCount = charCount / 10;
            chars[len] = (char) ('0' + rem);
            len++;
        }
        reverse(chars, slen, len - 1);
        return len;
    }

    private void reverse(char c[], int i, int j) {
        while (i < j) {
            char temp = c[i];
            c[i] = c[j];
            c[j] = temp;
            i++;
            j--;
        }
    }


    public static void main(String[] args) {
        StringCompression sc = new StringCompression();
        char ch[] = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        int len = sc.compress(ch);
        System.out.println(len);
    }
}
