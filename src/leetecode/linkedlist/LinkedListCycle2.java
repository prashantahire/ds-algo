package leetecode.linkedlist;

public class LinkedListCycle2 {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;
        while (slow != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                isCycle = true;
                break;
            }
        }
        if(!isCycle)
            return null;
        ListNode temp = head;
        while (temp != slow){
            temp = temp.next;
            slow = slow.next;
        }
        return temp;
    }
}
