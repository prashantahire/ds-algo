package leetecode.tree;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;
        sum = sum - root.val;
        if(root.left == null && root.right == null){
            return sum == 0 ? true : false;
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}
