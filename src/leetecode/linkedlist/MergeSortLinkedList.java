package leetecode.linkedlist;

public class MergeSortLinkedList {

    public static void main(String ...args){
        ListNode head = new ListNode(4);
        ListNode n2 = new ListNode(2);
        head.next = n2;
        ListNode n1 = new ListNode(1);
        n2.next = n1;
        ListNode n3 = new ListNode(3);
        n1.next=n3;
        new MergeSortLinkedList().sortList(head);
    }

    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }

    private ListNode mergeSort(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode mid = getMid(head);
        ListNode midNext = mid.next;
        mid.next = null;
        ListNode node1 = mergeSort(head);
        ListNode node2 = mergeSort(midNext);
        return mergeLists(node1, node2);
    }
    private ListNode mergeLists(ListNode node1, ListNode node2){

        if(node1 == null)
            return node2;
        if(node2 == null)
            return node1;
        ListNode res;
        if(node1.val <= node2.val){
            res = node1;
            res.next = mergeLists(node1.next, node2);
        }else{
            res = node2;
            res.next = mergeLists(node1, node2.next);
        }
        return res;
    }
    private ListNode getMid(ListNode node){
        ListNode slow = node;
        ListNode fast = node;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
