package leetecode.string;

public class LongestUnCommonSubSequence {
    public int findLUSlength(String a, String b) {
        if(a.equals(b))
            return -1;
        return Math.max(a.length(), b.length());
    }

    public static void main(String[] args) {
        LongestUnCommonSubSequence ls = new LongestUnCommonSubSequence();
        System.out.println(ls.findLUSlength("aaa", "aa"));
    }
}
