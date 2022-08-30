package leetecode.tree;

public class FindBottomLeftTreeValue {
    //Time: O(n)
    // Space: O(1) - constant
    int maxLvl = -1;
    int leftMost = -1;
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return leftMost;
    }

    private void dfs(TreeNode root, int lvl) {
        if(root == null)
            return;
        dfs(root.left, lvl+1);
        dfs(root.right, lvl+1);
        if(lvl > maxLvl){
            maxLvl = lvl;
            leftMost = root.val;
        }
    }
}
