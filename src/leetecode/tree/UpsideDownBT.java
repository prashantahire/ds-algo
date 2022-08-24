package leetecode.tree;

public class UpsideDownBT {

    public static void main(String ...args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        TreeNode rootNew = new UpsideDownBT().upsideDownBinaryTree(root);
        System.out.println(rootNew.val);
    }
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null || root.left == null)
            return root;
        TreeNode left = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;

        root.left = null;
        root.right = null;
        return left;
    }
}
