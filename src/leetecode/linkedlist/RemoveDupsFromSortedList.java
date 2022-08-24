package leetecode.linkedlist;

public class RemoveDupsFromSortedList {

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

        ListNode newhead = new RemoveDupsFromSortedList().deleteDuplicates(head);
        ListNode temp = newhead;
        while (temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode prev = newHead;
        ListNode current = head;
        ListNode next = head.next;
        boolean isDup = false;
        while (next != null){
            isDup = false;
            while (next!= null && current.val == next.val){
                current = next;
                next = next.next;
                isDup = true;
            }
            if(!isDup){
                prev.next = current;
                prev = current;
            }
            current = next;
            if(next != null)
                next= next.next;
        }
        if(prev != null)
            prev.next = current;
        return newHead.next;
    }
}
