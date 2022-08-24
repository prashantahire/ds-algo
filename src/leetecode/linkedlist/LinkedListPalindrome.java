package leetecode.linkedlist;

public class LinkedListPalindrome {

    //O^2
    public boolean isPalindrome(ListNode head) {
        ListNode t1 = head;
        while (t1.next!=null)
            t1=t1.next;
        ListNode back=t1;
        ListNode front = head;
        ListNode temp = head;
        if(t1.val != front.val)
            return false;
        front = front.next;
        while (back != front){
            temp = front;
            while (temp.next != t1)
                temp = temp.next;
            if(front.val != temp.val)
                return false;
            t1= temp;
            front = front.next;
        }
        return front.val == temp.val;
    }

    ListNode ref;
    public boolean isPalindrome2(ListNode head) {
        ref = head;
        return isPalindrome2Rec(head);
    }

    public boolean isPalindrome2Rec(ListNode node){
        if(node == null)
            return true;
        boolean ans = isPalindrome2Rec(node.next);
        ans = ans && ref.val == node.val;
        ref = ref.next;
        return ans;
    }

    //O(n) Half reverse and compare

}
