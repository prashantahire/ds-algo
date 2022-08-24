package leetecode.dynaprog;

import java.util.ArrayList;
import java.util.List;
//https://leetcode.com/problems/unique-binary-search-trees-ii/discuss/146258/Java-DP-beats-100
public class UniqueBSTs2 {

    public static void main(String ...args){
        UniqueBSTs2 u = new UniqueBSTs2();
        u.generateTrees(3);
    }
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<>();
        List<Integer> elist = new ArrayList<>();
        List<String> preOrderTrav = new ArrayList<>();
        if(n <=0)
            return ans;
        uniqueBstBt(0, n, null, null, elist, ans, preOrderTrav);
        return ans;
    }

    public void uniqueBstBt(int i, int n, TreeNode root, TreeNode node, List<Integer> elist, List<TreeNode> ans, List<String> preOrderTrav){
        if(i>=n){
            StringBuilder sb = new StringBuilder();
            preOrderTrav(root, sb);
            if(!preOrderTrav.contains(sb.toString())) {
                ans.add(preOrderCopy(root));
                preOrderTrav.add(sb.toString());
            }

            return;
        }
        for(int j=1; j<=n; j++){
            if(elist.contains(j))
                continue;
            TreeNode temp = addNode(root, j);
            elist.add(j);
            uniqueBstBt(i+1, n, (root == null? temp:root), temp, elist, ans, preOrderTrav);
            elist.remove(elist.size()-1);
            removeNode(root, j);
        }
    }

    public void preOrderTrav(TreeNode root, StringBuilder sb){
        if(root == null)
            return;
        sb.append(root.val);
        preOrderTrav(root.left, sb);
        preOrderTrav(root.right, sb);
    }

    public TreeNode preOrderCopy(TreeNode root){
        if(root == null)
            return null;
        TreeNode nr = new TreeNode(root.val);
        nr.left = preOrderCopy(root.left);
        nr.right = preOrderCopy(root.right);
        return nr;
    }

    public TreeNode addNode(TreeNode node, int j){
        if(node == null)
            return new TreeNode(j);
        if(j < node.val){
            node.left = addNode(node.left, j);
        }else{
            node.right = addNode(node.right, j);
        }
        return node;
    }
    public TreeNode removeNode(TreeNode node, int j){
        if(node == null || node.val == j)
            return null;
        if(j < node.val)
            node.left = removeNode(node.left, j);
        else
            node.right = removeNode(node.right, j);
        return node;
    }


    public List<TreeNode> generateTreesBt(int n) {
        List<TreeNode> ans = new ArrayList<>();
        if(n==0)
            return ans;
        return generateTreesBt(1,n);
    }
    public List<TreeNode> generateTreesBt(int start, int end) {

        List<TreeNode> ans = new ArrayList<>();
        if(start>end) {
            ans.add(null);
            return ans;
        }

        for(int i=start; i<=end; i++){

            List<TreeNode> leftSubtrees = generateTreesBt(start, i-1);
            List<TreeNode> rightSubtrees = generateTreesBt(i+1, end);
            for(TreeNode left : leftSubtrees){
                for(TreeNode right : rightSubtrees){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}