package leetecode.linkedlist;

public class RemoveDupFromSortedList1 {
    public static void main(String ...args){
        ListNode head = new ListNode(1);
        ListNode next11 = new ListNode(1);
        ListNode next1 = new ListNode(2);
        head.next = next11;
        next11.next = next1;
        ListNode next2 = new ListNode(3);
        next1.next = next2;
        ListNode next31 = new ListNode(3);
        next2.next = next31;
        ListNode next32 = new ListNode(3);
        next31.next = next32;
        ListNode next33 = new ListNode(3);
        next32.next = next33;
        ListNode next41 = new ListNode(4);
        next33.next = next41;
        ListNode next42 = new ListNode(4);
        next41.next = next42;
        ListNode next5 = new ListNode(5);
        next42.next = next5;
        ListNode next6 = new ListNode(6);
        next5.next = next6;

        ListNode newhead = new RemoveDupFromSortedList1().deleteDuplicates(head);
        ListNode temp = newhead;
        while (temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null)
            return head;

        ListNode current = head;
        ListNode next = head.next;
        while(next != null){
            while (next != null && current.val == next.val){
                next = next.next;
            }
            current.next = next;
            current = next;
            if(next != null)
                next = next.next;
        }
        return head;
    }
}
