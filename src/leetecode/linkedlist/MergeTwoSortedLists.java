package leetecode.linkedlist;

import java.util.List;

public class MergeTwoSortedLists {

    public static void main(String ...args){
        ListNode l1 = new ListNode(-9);
        l1.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(7);

        new MergeTwoSortedLists().mergeTwoLists(l1,l2);
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode dummyHead = new ListNode(-1);
        ListNode temp = dummyHead;
        while (temp1!=null && temp2!=null){
            if(temp1.val < temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;

            }else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        while (temp1!= null){
            temp.next = temp1;
            temp1 = temp1.next;
        }
        while (temp2!=null){
            temp.next = temp2;
            temp2 = temp2.next;
            temp = temp.next;
        }
        return dummyHead.next;
    }
}
