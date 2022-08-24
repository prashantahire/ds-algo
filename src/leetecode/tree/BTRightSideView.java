package leetecode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BTRightSideView {

    public static void main(String ...args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        BTRightSideView bt = new BTRightSideView();
        System.out.println(bt.rightSideView(root));
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        TreeNode preTemp = null;
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp == null){
                ans.add(preTemp.val);
                if(!queue.isEmpty())
                    queue.offer(null);
                continue;
            }
            if(temp.left != null)
                queue.offer(temp.left);
            if(temp.right != null)
                queue.offer(temp.right);
            preTemp = temp;
        }
        return ans;
    }
}
