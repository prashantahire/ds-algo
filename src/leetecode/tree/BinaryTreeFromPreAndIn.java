package leetecode.tree;

public class BinaryTreeFromPreAndIn {

    public static void main(String ...args){
        int p[]={3,9,20,15,7};
        int i[]={9,3,15,20,7};
        BinaryTreeFromPreAndIn b = new BinaryTreeFromPreAndIn();
        b.buildTree(p, i);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeRec(0, preorder.length-1, 0, preorder, inorder);
    }

    public TreeNode buildTreeRec(int i, int j, int pre_r, int[] preorder, int[] inorder){
        if(i > j)
            return null;
        int r = findRoot(i, j, pre_r, preorder, inorder);
        if(r == -1) return null;
        TreeNode node = new TreeNode(inorder[r]);
        node.left = buildTreeRec(i, r-1, pre_r+1, preorder, inorder);
        node.right = buildTreeRec(r+1, j, pre_r+1, preorder, inorder);
        return node;
    }

    public int findRoot(int i, int j, int pre_r, int[] preorder, int[] inorder ){
        for(int k=pre_r; k<preorder.length; k++){
            for(int l=i; l<=j; l++)
                if(preorder[k] == inorder[l])
                    return l;
        }
        return -1;
    }

    public TreeNode buildTreeFinal(int[] preorder, int[] inorder) {
        return buildTreeFinalRec(0, inorder.length-1, 0, preorder, inorder);
    }

    public TreeNode buildTreeFinalRec(int start, int end, int preIdx, int[] preorder, int[] inorder){
        if(start > end)
            return null;

        int inOrderIdx = findInorderIdx(start, end, preorder[preIdx], inorder);
        if (inOrderIdx == -1) return null;

        int leftTreesize = inOrderIdx-start;
        TreeNode node = new TreeNode(preorder[preIdx]);
        node.left = buildTreeFinalRec(start, inOrderIdx-1, preIdx+1, preorder,inorder);
        node.right = buildTreeFinalRec(inOrderIdx+1, end, preIdx+leftTreesize+1, preorder,inorder);
        return node;
    }

    int findInorderIdx(int start, int end, int key, int[] inorder){
        for(int i=start; i<=end; i++){
            if(inorder[i] == key)
                return i;
        }
        return -1;
    }
}
