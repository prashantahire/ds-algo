package leetecode.tree;

import java.util.*;

public class ZigzagLevelOrder {

    public static void main(String ...args){
        Deque dq1 = new LinkedList();
        Deque dq2 = new LinkedList();
        dq1.offerLast(1);
        dq1.offerLast(2);
        dq1.offerLast(3);
        dq1.offerLast(4);
        dq2.offerFirst(1);
        dq2.offerFirst(2);
        dq2.offerFirst(3);
        dq2.offerFirst(4);
        System.out.println(dq1);
        System.out.println(dq2);
//        System.out.println(dq);
//        System.out.println(dq.pollFirst());
//        System.out.println(dq);
//        System.out.println(dq.pollFirst());
//        System.out.println(dq);
//        System.out.println(dq.pollLast());
//        System.out.println(dq);
//        System.out.println(dq.pollLast());
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);
        int level = 1;
        LinkedList<Integer> nodeVals = new LinkedList<>();
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp == null){
                level++;
                ans.add(nodeVals);
                if(!queue.isEmpty()){
                    queue.offer(null);
                    nodeVals = new LinkedList<>();
                }
                continue;
            }
            if(level % 2 == 1)
                nodeVals.addLast(temp.val);
            else
                nodeVals.addFirst(temp.val);

            if(temp.left != null)
                queue.offer(temp.left);
            if(temp.right != null)
                queue.offer(temp.right);
        }
        return ans;
    }

    public List<List<Integer>> zigzagLevelOrderRec(TreeNode root) {
        List<List<Integer>> ans  = new ArrayList<>();
        if(root == null)
            return ans;
        zigzagLevelOrderRec(root, 0, ans);
        return ans;
    }

    public void zigzagLevelOrderRec(TreeNode root, int cl, List<List<Integer>> ans){
        if(root == null)
            return;
        if(cl >= ans.size()){
            ans.add(new LinkedList<>());
        }
        if(cl % 2 == 1)
            ((LinkedList)ans.get(cl)).addFirst(root.val);
        else
            ((LinkedList)ans.get(cl)).addLast(root.val);
        zigzagLevelOrderRec(root.left, cl+1, ans);
        zigzagLevelOrderRec(root.right, cl+1, ans);
    }
}
