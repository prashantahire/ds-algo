package leetecode.tree;

public class FlattenBT {
    public void flatten(TreeNode root) {
        flattenRec(root);
    }
    public TreeNode flattenRec(TreeNode root){
        if (root== null)
            return root;
        TreeNode left = flattenRec(root.left);
        TreeNode right = flattenRec(root.right);
        root.right = left;
        TreeNode temp = root;
        while (temp.right != null)
            temp = temp.right;
        temp.right = right;
        return root;
    }

    public void flattenFinal(TreeNode root) {
        flattenRec(root, null);
    }

    private TreeNode flattenRec(TreeNode root, TreeNode prev){
        if(root == null)
            return prev;
        prev = flattenRec(root.right, prev);
        prev = flattenRec(root.left, prev);
        root.right = prev;
        root.left = null;
        prev = root;
        return prev;
    }
}
