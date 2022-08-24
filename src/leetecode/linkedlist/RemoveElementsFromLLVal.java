package leetecode.linkedlist;

//https://leetcode.com/problems/remove-linked-list-elements/
public class RemoveElementsFromLLVal {

    public static void main(String ...args){
        RemoveElementsFromLLVal rm = new RemoveElementsFromLLVal();
        ListNode h = new ListNode(1);
        ListNode n1 = new ListNode(1);
        h.next = n1;
        rm.removeElements(h, 1);
    }
    public ListNode removeElements(ListNode head, int val) {
        if(head == null)
            return head;

        ListNode prev = null;
        ListNode cur = head;
        ListNode newHead = head;
        ListNode next = head.next;
        while (cur != null){
            if(cur.val == val){
                if(cur == newHead){
                    newHead = next;
                }
                cur.next = null;
                if(prev != null)
                    prev.next = next;
            }else {
                prev = cur;
            }
            cur = next;
            if(next != null)
                next = next.next;
        }
        return newHead;
    }
}
