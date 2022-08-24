package leetecode;

public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)
            return head;
        
        ListNode temp1 = head;
        ListNode temp2 = head;
        ListNode prev = null;
        int count = 0;
        
        while(temp1 != null) {
            if(count <= n) {
                temp1 = temp1.next;
                count++;
            }else {
                temp1 = temp1.next;
                prev = temp2;
                temp2 = temp2.next;
            }
        }
        if(prev == null) {
            head = temp2.next;
        }
        if(prev != null) {
            prev.next = temp2.next;
        }
        return head;
    }
}
