package leetecode.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        btPaths(root, "", ans);
        return ans;
    }

    private void btPaths(TreeNode root, String path, List<String> ans){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            ans.add(path+root.val);
        }
        btPaths(root.left, path+root.val+"->", ans);
        btPaths(root.right, path+root.val+"->", ans);
    }
}
