

package leetecode.recursion;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class PascalTriangle {
    
    public static void main(String ...args) {
        PascalTriangle pt = new PascalTriangle();
        pt.generate(5);
    }
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> tree = new ArrayList<>();
        branch(numRows, tree);
        System.out.println(tree);
        return tree;
    }

    private void branch(int row, List<List<Integer>> tree) {
        if (row == 1) {
            tree.add(Arrays.asList(1));
            return;
        }
        branch(row - 1, tree);
        List<Integer> prevBr = tree.get(row - 2);
        List<Integer> newBr = new ArrayList<>();
        newBr.add(1);
        for (int i = 0; i < prevBr.size() - 1; i++) {
            newBr.add(prevBr.get(i) + prevBr.get(i + 1));
        }
        newBr.add(1);
        tree.add(newBr);
    }
}
