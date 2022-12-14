package leetecode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderIterTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();
        if(root == null)
            return list;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while(!s1.isEmpty()){
            TreeNode temp = s1.pop();
            s2.push(temp);
            if(temp.left != null)
                s1.push(temp.left);
            if(temp.right != null)
                s1.push(temp.right);
        }
        while (!s2.isEmpty()){
            list.add(s2.pop().val);
        }
        return list;
    }
}
