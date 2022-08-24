package leetecode.tree;

public class BinaryTreeFromInAndPost {

    public static void main(String ...args){
        int io[] = {9,3,15,20,7};
        int po[] = {9,15,7,20,3};
        new BinaryTreeFromInAndPost().buildTree(io, po);
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        return buildTreeRec(0, inorder.length-1, postorder.length-1, inorder, postorder);
    }

    public TreeNode buildTreeRec(int inMin, int inMax, int postPos, int[] inorder, int[] postorder){
        if(inMin > inMax || postPos < 0)
            return null;
        int val = postorder[postPos];
        int inPos = findInPos(inMin, inMax, val, inorder);

        TreeNode node = new TreeNode(val);
        node.left = buildTreeRec(inMin, inPos-1, postPos-(inMax-inPos+1), inorder, postorder);
        node.right = buildTreeRec(inPos+1, inMax, postPos-1, inorder, postorder);
        return node;
    }

    public int findInPos(int k, int l, int val, int[] inorder){
        for(int i=k; i<=l; i++){
            if(inorder[i] == val)
                return i;
        }
        return -1;
    }

    public TreeNode buildTreeFinal(int[] inorder, int[] postorder) {
        return buildTreeFinalRec(0, inorder.length-1, postorder.length-1, postorder, inorder);
    }

    public TreeNode buildTreeFinalRec(int start, int end, int postIdx, int[] postorder, int[] inorder){
        if(start > end || postIdx < 0)
            return null;

        int inOrderIdx = findInPos(start, end, postorder[postIdx], inorder);
        if (inOrderIdx == -1) return null;

        int rightTreesize = end-inOrderIdx;
        TreeNode node = new TreeNode(postorder[postIdx]);
        node.left = buildTreeFinalRec(start, inOrderIdx-1, postIdx-rightTreesize-1, postorder,inorder);
        node.right = buildTreeFinalRec(inOrderIdx+1, end, postIdx-1, postorder,inorder);
        return node;
    }
}
