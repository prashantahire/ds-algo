package leetecode.array;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int numToadd = 1;
        for(int i=digits.length-1; i>=0; i--) {
            int tempSum = digits[i]+numToadd;
            digits[i] = tempSum%10;
            numToadd = tempSum/10;
        }
        if(numToadd !=0) {
            int b[] = new int[digits.length+1];
            b[0] = numToadd;
            for(int i=1; i<b.length; i++) {
                b[i] = digits[i-1];
            }
            return b;
        }else
            return digits;
    }
}
