package leetecode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal {
    public static void main(String ...args){
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        root.right=two;
        two.left = three;
        System.out.println(new InOrderTraversal().inorderTraversal(root));
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        List<Integer> list = new ArrayList<>();
        if(temp == null)
            return list;
        while (temp!= null || !stack.isEmpty()){
            if (temp != null){
                stack.push(temp);
                temp = temp.left;
                continue;
            }
            temp = stack.pop();
            list.add(temp.val);
            temp = temp.right;
        }
        return list;
    }

}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
