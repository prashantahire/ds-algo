package leetecode.tree;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(root.val == p.val || root.val == q.val)
            return root;
        boolean left = find(root.left, p, q);
        boolean right = find(root.right, p, q);
        if(left && right)
            return root;
        if(left)
            return lowestCommonAncestor(root.left, p, q);
        else
            return lowestCommonAncestor(root.right, p, q);
    }

    private boolean find(TreeNode root, TreeNode p, TreeNode q){
        if (root == null)
            return false;
        if(root.val == p.val || root.val == q.val)
            return true;
        return find(root.left, p,q) || find(root.right, p, q);
    }


    //Improved
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root.val == p.val || root.val == q.val)
            return root;
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right= lowestCommonAncestor2(root.right, p, q);
        if(left != null && right!=null)
            return root;
        return left!=null ? left : right;
    }
}
