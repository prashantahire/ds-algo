package leetecode.linkedlist;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = head.next;
        while (cur != null){
            cur.next = prev;
            prev = cur;
            cur = next;
            if(next != null)
                next = next.next;
        }
        return prev;
    }

    public ListNode reverseListRec(ListNode head) {
       return  reverseList(head, null);
    }

    private ListNode reverseList(ListNode current, ListNode prev){
        if(current == null)
            return prev;
        ListNode head = reverseList(current.next, current);
        current.next = prev;
        return head;
    }
}
