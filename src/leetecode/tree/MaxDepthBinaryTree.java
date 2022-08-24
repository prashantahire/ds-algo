package leetecode.tree;

import java.util.HashMap;
import java.util.Map;

public class MaxDepthBinaryTree {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int leftHt = 1+maxDepth(root.left);
        int rightHt = 1+maxDepth(root.right);
        return Math.max(leftHt, rightHt);

        //Map map = new HashMap();
        //map.entrySet().forEach(entry -> entry.);
    }
}
