package leetecode.tree.bst;

public class SortedLLToBST {

    private ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;

        ListNode mid = findMid(head);
        TreeNode node = new TreeNode(mid.val);

        node.left = sortedListToBST(head);
        node.right = sortedListToBST(mid.next);
        return node;
    }

    public ListNode findMid(ListNode head){
        ListNode prev = null;
        ListNode slower = head;
        ListNode faster = head;

        while (faster != null && faster.next != null){
            prev = slower;
            slower = slower.next;
            faster = faster.next.next;
        }

        if (prev != null)
            prev.next = null;

        return slower;
    }

    public TreeNode sortedListToBST2(ListNode head){
        this.head = head;
        return sortedListBSTRec(0, findLen(head)-1);
    }

    public TreeNode sortedListBSTRec(int i, int j){
        if(i > j)
            return null;
        int m = (i+j)/2;
        TreeNode left = sortedListBSTRec(i, m-1);
        TreeNode node = new TreeNode(head.val);
        head = head.next;
        node.left = left;
        node.right = sortedListBSTRec(m+1, j);
        return node;
    }
    public int findLen(ListNode head){
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}