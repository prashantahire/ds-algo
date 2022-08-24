

package leetecode.linkedlist;


//Given 1->2->3->4, you should return the list as 2->1->4->3.
//https://leetcode.com/problems/swap-nodes-in-pairs/
public class SwapNodesInPairs {

    public static void main(String ...args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        new SwapNodesInPairs().swapPairs2(head);
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode newHead = head.next;
        ListNode node = head;
        ListNode temp = null;
        ListNode temp2 = null;
        while (node != null) {
            temp = node.next;
            if(node.next != null) {
                if(node.next.next != null && node.next.next.next != null) {
                    node.next = node.next.next.next;
                }else {
                    node.next = node.next.next;
                }                
            }
            if(temp != null){
            temp2 = temp.next;
            temp.next = node;                
            }else{
                temp2 = temp;
            }
            node = temp2;
        }
        return newHead;
    }
    //better
    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            second.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
