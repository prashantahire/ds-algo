package leetecode.linkedlist;

public class PartitionList {
    public static void main(String ...args){
        ListNode head = new ListNode(5);
        ListNode next1 = new ListNode(3);
        head.next = next1;
        ListNode next2 = new ListNode(3);
        next1.next = next2;
        ListNode next31 = new ListNode(2);
        next2.next = next31;
        ListNode next32 = new ListNode(1);
        next31.next = next32;
        ListNode next33 = new ListNode(4);
        next32.next = next33;
//        ListNode next41 = new ListNode(4);
//        next33.next = next41;
//        ListNode next42 = new ListNode(4);
//        next41.next = next42;
//        ListNode next5 = new ListNode(5);
//        next42.next = next5;
//        ListNode next6 = new ListNode(6);
//        next5.next = next6;

        ListNode newhead = new PartitionList().partition(head, 5);
        ListNode temp = newhead;
        while (temp != null){
            System.out.println(temp.val);
            temp = temp.next;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode nodeX = head;
        ListNode prevX = null;
        while (nodeX != null && nodeX.val < x){
            prevX = nodeX;
            nodeX = nodeX.next;
        }

        ListNode current = nodeX;
        ListNode newHead = head;
        ListNode temp = null;
        ListNode prev = null;
        while (current != null){
            if(current.val < x){
                temp = current.next;
                if(prevX == null) {
                    prevX = current;
                    newHead = current;
                }
                else
                    prevX.next=current;
                current.next = nodeX;
                prevX = current;
                current = temp;
                prev.next = current;
            }else {
                prev = current;
                current = current.next;
            }
        }
        return newHead;
    }

    public ListNode partitionEasy(ListNode head, int x) {

        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;

        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;

        while (head != null){
            if(head.val < x){
                before.next = head;
                before = before.next;
            }else{
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        before.next = afterHead.next;
        after.next = null;
        return beforeHead.next;
    }
}
