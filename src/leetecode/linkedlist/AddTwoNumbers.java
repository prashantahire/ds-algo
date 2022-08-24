package leetecode.linkedlist;

// https://leetcode.com/problems/add-two-numbers-ii/submissions/
// 9/10
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode revL1 = reverse(l1);
        ListNode revL2 = reverse(l2);

        ListNode head = new ListNode(-1);
        int carry = 0;
        ListNode temp = head;
        while(revL1 != null || revL2 != null) {
            int sum = (revL1 != null ? revL1.val : 0) + (revL2 != null ? revL2.val : 0) + carry;
            carry = sum/10;
            temp.next = new ListNode(sum%10);
            temp = temp.next;
            if(revL1 != null)
                revL1 = revL1.next;
            if(revL2 != null)
                revL2 = revL2.next;
        }
        if(carry != 0) {
            temp.next = new ListNode(carry);
            temp = temp.next;
        }
        return reverse(head.next);
    }

    private ListNode reverse(ListNode l){
        ListNode prev = null;
        ListNode curr = l;
        while(curr!=null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev =curr;
            curr = next;
        }
        return prev;
    }
}
