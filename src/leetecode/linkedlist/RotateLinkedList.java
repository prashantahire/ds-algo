package leetecode.linkedlist;

public class RotateLinkedList {
    
    public static void main(String ...args) {
        RotateLinkedList rl = new RotateLinkedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        //head = rl.rotateList(head, 7);
        head = rl.rotateListRev(head, 2);
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.val+" - ");
            temp = temp.next;
        }
    }
    public ListNode rotateList(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        int ls = 0;
        ListNode tmp = head;
        while(tmp != null) {
            ls++;
            tmp = tmp.next;
        }
        k=k%ls;
        for(int i=1; i<=k; i++) {
            ListNode sl = head;
            while(sl.next.next != null) {
                sl = sl.next;
            }
            ListNode temp = head;
            head = sl.next;
            head.next = temp;
            sl.next = null;
        }
        return head;
    }
    public ListNode rotateListRev(ListNode head, int k) {
        if(head == null || head.next == null)
            return head;
        int ls =0;
        ListNode temp = head;
        while(temp!= null) {
            temp=temp.next;
            ls++;
        }
        ListNode prev = null;
        ListNode current = head;
        ListNode next = current;
        k=k%ls;
        int i=0;
        int j = ls - k;
        ListNode newHead;
            while(i<ls-k) {
                next = current.next;
                current.next = prev;
                prev = current;
                current =next;
                i++;
            }
            newHead = prev;
            prev = null;
            while(j<ls) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                j++;
            }
            head.next = prev;
            return reverseList(newHead);
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = current;
        while(current != null) {

                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
        }
        return prev;
    }

    public ListNode rotateListFinal(ListNode head, int k) {

        if(head == null || head.next==null || k==0)
            return head;
        //get length;
        int len = 0;
        ListNode temp = head;
        while (temp!= null){
            temp=temp.next;
            len++;
        }

        ListNode prev = null;
        ListNode cur = head;
        int i=0;
        k = k%len;

        if(k==0)
            return head;

        //travel till len-k
        while (i<(len-k)){
            prev = cur;
            cur = cur.next;
        }

        //change l-k th node as new head
        prev.next = null;
        ListNode nh = cur;

        //travel till last and point last node to head.
        while (cur.next != null){
            cur = cur.next;
        }
        cur.next = head;
        return nh;
    }
}
