package leetecode.tree;

public class MinDepthOfBT {
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        int leftHt = 1+minDepth(root.left);
        int rightHt = 1+minDepth(root.right);
        if(root.left != null && root.right != null)
            return Math.min(leftHt, rightHt);
        else if(root.left != null)
            return leftHt;
        else
            return rightHt;
    }
}
