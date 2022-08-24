package leetecode.tree.bst;

public class SortedArrToBalancedBST {

    public static void main(String ...args){
        SortedArrToBalancedBST s = new SortedArrToBalancedBST();
        int a[] = {-10,-3,0,5,9};
        TreeNode node = s.sortedArrayToBST(a);
        System.out.println("");
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBSTRec(0, nums.length-1, nums);
    }

    public TreeNode sortedArrayToBSTRec(int i, int j, int[] a){
        if(i>j)
            return null;
        int m = (i+j)/2;
        TreeNode node = new TreeNode(a[m]);
        node.left = sortedArrayToBSTRec(i, m-1, a);
        node.right = sortedArrayToBSTRec(m+1, j, a);
        return node;
    }
}
