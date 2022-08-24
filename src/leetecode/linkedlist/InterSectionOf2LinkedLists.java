package leetecode.linkedlist;
//https://leetcode.com/problems/intersection-of-two-linked-lists/

public class InterSectionOf2LinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if(headA == null || headB == null)
            return null;
        ListNode temp = headA;
        while(temp.next != null)
            temp = temp.next;
        temp.next = headA;

        ListNode slow = headB;
        ListNode fast = headB;
        boolean isCycle = false;

        while (fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                isCycle = true;
                break;
            }
        }
        if(!isCycle){
            temp.next = null;
            return null;
        }
        ListNode tempB = headB;
        while(slow != tempB){
            slow = slow.next;
            tempB = tempB.next;
        }
        temp.next = null;
        return slow;
    }

    //two pointers approach
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        ListNode pa = headA;
        ListNode pb = headB;
        int cnta = 0;
        int cntb = 0;
        while (cnta <=1 && cntb<=1){
            if(pa == null) {
                pa = headB;
                cnta++;
            }
            if(pb == null) {
                cntb ++;
                pb = headA;
            }
            if(pa == pb)
                return pa;
            pa = pa.next;
            pb = pb.next;
        }
        return null;
    }
}
