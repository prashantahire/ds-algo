package leetecode.tree.bst;

public class KthSmallestInBST {
    int count = 0;

    public static void main(String ...args){

    }
    public int kthSmallest(TreeNode root, int k) {
        this.count=0;
        return kthSmallestRec(root, k);
    }
    private int kthSmallestRec(TreeNode root, int k){
        if(root == null)
            return -1;
        int kthSmallEle = kthSmallestRec(root.left, k);
        if(kthSmallEle != -1)
            return kthSmallEle;

        count++;
        if (count == k)
            return root.val;

        return kthSmallestRec(root.right, k);
    }
}
