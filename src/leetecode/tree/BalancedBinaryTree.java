package leetecode.tree;

public class BalancedBinaryTree {
    private boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        isBalancedRec(root);
        return isBalanced;
    }

    public int isBalancedRec(TreeNode root){
        if(root == null || !isBalanced)
            return 0;
        int lefht = 1+isBalancedRec(root.left);
        int rightht = 1+isBalancedRec(root.right);
        if(Math.abs(lefht - rightht) > 1)
            isBalanced = false;
        return Math.max(lefht, rightht);
    }
}
