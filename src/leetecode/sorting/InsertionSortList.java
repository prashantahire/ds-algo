package leetecode.sorting;

public class InsertionSortList {

    public static void main(String ...args){
        ListNode head = new ListNode(4);
        ListNode n1 = new ListNode(2);
        head.next = n1;
        ListNode n2 = new ListNode(1);
        n1.next = n2;
        ListNode n3 = new ListNode(3);
        n2.next = n3;
        new InsertionSortList().insertionSortList(head);

    }
    public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return head;

        ListNode tempi = head;
        ListNode tj;
        ListNode tjp;
        ListNode nexti;
        while (tempi != null){
            tj = tempi;
            nexti = tempi.next;

            while (tj != head){
                tjp = head;
                ListNode prev = null;
                while (tjp.next != tj){
                    prev = tjp;
                    tjp = tjp.next;
                }
                if(tj.val < tjp.val){
                    ListNode temp = tj.next;
                    tj.next = tjp;
                    tjp.next = temp;
                    if(prev != null) prev.next = tj;
                    if(tjp == head)
                        head = tj;
                }else {
                    tj = tjp;
                }
            }
            tempi = nexti;
        }
        return head;
    }

    public ListNode insertionSortList2(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode current = dummy;
        ListNode preInsert;
        ListNode toInsert;
        while (current != null && current.next != null){
            if(current.val <= current.next.val)
                current = current.next;
            else{
                toInsert = current.next;
                preInsert = dummy;
                while (preInsert.next.val <= toInsert.val)
                    preInsert = preInsert.next;

                ListNode temp1 = preInsert.next;
                preInsert.next = toInsert;
                current.next = toInsert.next;
                toInsert.next = temp1;
            }
        }
        return dummy.next;
    }
}
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }