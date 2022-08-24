package leetecode.linkedlist;

public class ReorderList {
    //On^2
    public void reorderList(ListNode head) {

        if(head == null || head.next == null)
            return;
        ListNode current = head;
        ListNode p1;
        ListNode prev;
        while (current.next != null){
            p1=head; prev = null;
            while (p1.next != null){
                prev = p1;
                p1=p1.next;
            }
            if(prev == current){
                current = current.next;
                continue;
            }
            ListNode temp = current.next;
            current.next = p1;
            prev.next = null;
            current = temp;
            p1.next = current;
        }
    }
    //O(n)

    public void reorderList2(ListNode head) {

        if (head == null || head.next == null)
            return;
        //find mid
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //Revers right half
        ListNode curR = slow.next;
        ListNode prev = null;
        while (curR != null){
            ListNode temp = curR.next;
            curR.next = prev;
            prev = curR;
            curR = temp;
        }
        //separate fist list;
        slow.next = null;
        ListNode c1 = head;
        ListNode c2 = prev;

        //Merge c1 and c2
        while (c1 != null && c2 != null){
            ListNode t1 = c1.next;
            c1.next = c2;
            ListNode t2 = c2.next;
            c2.next = t1;
            c1=t1;
            c2=t2;
        }
    }
}
