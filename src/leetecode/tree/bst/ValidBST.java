package leetecode.tree.bst;

import java.util.Stack;

public class ValidBST {
    /**
     * Uppelimit and lowerlimitL
     * if traveling left of the node then upperlimit = node.val
     * if traveling right of the node then lowerlimit = node.val
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBSTPreFinal(root, null, null);
    }


    public boolean isValidBSTPreFinal(TreeNode root, Integer ll, Integer ul) {
        if(root == null)
            return true;
        if(ll != null && root.val <= ll) return false;
        if(ul != null && root.val >= ul) return false;
        return isValidBSTPreFinal(root.left, ll, root.val) && isValidBSTPreFinal(root.right, root.val, ul);
    }
//Iterative approach with stack - Inorder traversal.
    //Based on fat BST inorder gives sorted list. If it violates then not a bst.
    public boolean isValidBSTIter(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        Double inorder = - Double.MAX_VALUE;
        while (!stack.isEmpty() || root != null){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                if(root.val <=inorder)
                    return false;
                inorder = (double) root.val;
                root = root.right;
            }
        }
        return true;
    }
}
 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}