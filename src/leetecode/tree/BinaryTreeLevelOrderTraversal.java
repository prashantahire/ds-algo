package leetecode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null)
            return null;
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> levels = new ArrayList<>();
        queue.offer(root);
        queue.offer(null);
        List<Integer> nodeVals = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp == null){
                levels.add(nodeVals);
              if(!queue.isEmpty()){
                  nodeVals = new ArrayList<>();
                  queue.offer(null);
              }
              continue;
            }
            nodeVals.add(temp.val);
            if(temp.left != null)
                queue.offer(temp.left);
            if(temp.right != null)
                queue.offer(temp.right);
        }
        return levels;
    }

    public List<List<Integer>> levelOrderRec(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelOrderRec(root, 0, ans);
        return ans;
    }
    public void levelOrderRec(TreeNode root, int cl, List<List<Integer>> ans){
        if(root == null)
            return;
        if(ans.size() < cl)
            ans.add(new ArrayList<>());
        levelOrderRec(root.left, cl+1, ans);
        ans.get(cl).add(root.val);
        levelOrderRec(root.right, cl+1, ans);
    }
}
