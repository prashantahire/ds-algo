package leetecode.bit;

public class NumberOf1Bits {

    public static void main(String ...args){
        NumberOf1Bits nb = new NumberOf1Bits();
        System.out.println(nb.hammingWeight(5));
        System.out.println(nb.hammingWeight(10));
    }
    public int hammingWeight(int n) {

        int mask = 1;
        int oneBits = 0;
        for(int i=0; i<32; i++){
            if((n & mask) != 0)
                oneBits++;
            mask <<=1;
        }
        return oneBits;
    }
}
