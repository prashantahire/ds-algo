package leetecode.linkedlist;

public class ReverseLinkedList2 {

    public static void main(String ...args){
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        ListNode newhead = new ReverseLinkedList2().reverseBetween(head, 2, 5);
        ListNode temp = newhead;
        while (temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {

        int i=1;
        ListNode prev = null;
        ListNode current = head;
        ListNode mPrev = null;
        ListNode nNext = null;
        while (current != null){
            if(i==m)
                mPrev = prev;
            if(i==n){
                nNext = current.next;
                break;
            }
            i++;
            prev = current;
            current = current.next;
        }

        ListNode next;
        prev = nNext;
        current = mPrev!= null? mPrev.next: head;
        while (current != nNext){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        if(mPrev != null)
            mPrev.next = prev;
        return mPrev != null ? head : prev;
    }
}
