package leetecode.tree.completetree;

public class CountNodes {
    public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int countNodes2(TreeNode root) {

        if(root == null)
            return 0;
        int lh = heightLeft(root);
        int rh = heightRight(root);

        if(lh == rh){
            return (1<<lh+1) - 1;
        }
        return 1+countNodes(root.left)+countNodes(root.right);
    }

    private int heightLeft(TreeNode root){
        int ht = 0;
        while (root.left != null){
            ht++;
            root = root.left;
        }
        return ht;
    }

    private int heightRight(TreeNode root){
        int ht = 0;
        while (root.right != null){
            ht++;
            root = root.right;
        }

        return ht;
    }

}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
}