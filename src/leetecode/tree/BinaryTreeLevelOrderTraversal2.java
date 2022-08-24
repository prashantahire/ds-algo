package leetecode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal2 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<Integer> nodes = new ArrayList<>();
        q.offer(root);
        q.offer(null);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node == null) {
                ((LinkedList) ans).addFirst(nodes);
                if (!q.isEmpty()) {
                    q.offer(null);
                    nodes = new ArrayList<>();
                }
                continue;
            }
            nodes.add(node.val);
            if (node.left != null)
                q.offer(node.left);
            if (node.right != null)
                q.offer(node.right);
        }
        return ans;
    }

    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();

        if (root == null)
            return ans;
        levelOrderBottom2Rec(0, root, ans);
        return ans;
    }

    private void levelOrderBottom2Rec(int cl, TreeNode root, LinkedList<List<Integer>> ans){
        if(root == null)
            return;
        if(cl >= ans.size()){
            ans.addFirst(new ArrayList<>());
        }
        levelOrderBottom2Rec(cl+1, root.left, ans);
        levelOrderBottom2Rec(cl+1, root.right, ans);
        ans.get(ans.size()-cl-1).add(root.val);
    }
}
