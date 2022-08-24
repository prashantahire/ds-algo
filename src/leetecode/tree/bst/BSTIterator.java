package leetecode.tree.bst;
//https://leetcode.com/problems/binary-search-tree-iterator/

import java.util.Stack;

class BSTIterator {

    public static void main(String ...args){
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);
        BSTIterator iter = new BSTIterator(root);
        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
        System.out.println(iter.next());
        System.out.println(iter.hasNext());
    }
    private Stack<TreeNode> stack = new Stack<>();
    private TreeNode next;
    public BSTIterator(TreeNode root) {
        next = root;
    }

    /** @return the next smallest number */
    public int next() {
        int nextVal = -1;
        while(next != null || !stack.isEmpty()){
            if(next != null){
                stack.push(next);
                next = next.left;
                continue;
            }
            next = stack.pop();
            nextVal = next.val;
            next = next.right;
            break;
        }
        return nextVal;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty() || next != null;
    }
}
