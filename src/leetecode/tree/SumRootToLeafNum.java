package leetecode.tree;

public class SumRootToLeafNum {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        dfsSum(root, 0);
        return sum;
    }

    private void sumNumRec(TreeNode root, String s){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            sum+=Integer.parseInt(s+root.val);
        }
        if(root.left != null)
            sumNumRec(root.left, s+root.val);
        if(root.right != null){
            sumNumRec(root.right, s+root.val);
        }
    }

    private void dfsSum(TreeNode root, int curSum){
        if(root == null)
            return;
        curSum = curSum*10 + root.val;
        if(root.left == null && root.right == null){
            sum+=curSum;
            return;
        }
        dfsSum(root.left, curSum);
        dfsSum(root.right, curSum);
    }

    //no global var
    private int dfsSum2(TreeNode root, int curSum){
        if(root == null)
            return 0;
        curSum = curSum*10 + root.val;
        if(root.left == null && root.right == null){
            return curSum;
        }
        return dfsSum2(root.left, curSum) +dfsSum2(root.right, curSum);
    }
}
