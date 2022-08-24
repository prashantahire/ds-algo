package leetecode.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null)
            return ans;
        pathSumRec(root, sum, ans, list);
        return ans;
    }

    public void pathSumRec(TreeNode root, int sum, List<List<Integer>> ans, List<Integer> list){
        if(root == null)
            return;
        sum = sum - root.val;

        if(root.left == null && root.right == null){
            if(sum == 0) {
                list.add(root.val);
                ans.add(new ArrayList<>(list));
                list.remove(list.size()-1);
            }
            return;
        }
        list.add(root.val);
        pathSumRec(root.left, sum, ans, list);
        pathSumRec(root.right, sum, ans, list);
        list.remove(list.size()-1);
    }
}
