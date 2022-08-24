

package leetecode;


import java.util.ArrayList;
import java.util.List;


public class GenerateParenthesis {

    public static void main(String... args) {
        GenerateParenthesis gp = new GenerateParenthesis();
        // System.out.println(gp.generateParenthesis(1));
        System.out.println(gp.generateParenthesis(2));
       // System.out.println(gp.generateParenthesis(3));
       // System.out.println(gp.generateParenthesis(4));
    }

    public List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        buildParenthesis(sb, n, 0, 0, list);
        return list;
    }

    private void buildParenthesis(StringBuilder sb, int n, int lpc, int rpc, List<String> list) {
        if (sb.length() == n*2) {
            list.add(sb.toString());
            return;
        }
        if(lpc < n) {
            StringBuilder osb = new StringBuilder(sb.toString());
            buildParenthesis(osb.append("("), n, lpc+1, rpc, list);
        }
        if(rpc<lpc) {
            StringBuilder osb = new StringBuilder(sb.toString());
            buildParenthesis(osb.append(")"), n, lpc, rpc+1, list);            
        }
            
    }
}
