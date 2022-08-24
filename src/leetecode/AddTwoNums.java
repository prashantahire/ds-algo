

package leetecode;


public class AddTwoNums {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = 0;
        int num2 = 0;
        int multiplier = 1;

        ListNode temp = l1;
        while (temp != null) {
            num1 = num1 + temp.val * multiplier;
            multiplier = multiplier * 10;
            temp = temp.next;
        }
        System.out.println(num1);
        temp = l2;
        multiplier = 1;
        while (temp != null) {
            num2 = num2 + temp.val * multiplier;
            multiplier = multiplier * 10;
            temp = temp.next;
        }
        System.out.println(num2);
        int sum = num1 + num2;

        ListNode l3 = null;
        ListNode tmp = null;
        while (sum >= 1) {
            ListNode temp1 = new ListNode(sum % 10);
            sum = sum / 10;
            if (l3 == null) {
                l3 = temp1;
                tmp = temp1;
            }
            else {
                tmp.next = temp1;
                tmp = tmp.next;
            }

        }
        return l3;
        //Integer.MAX_VALUE
    }
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode p = l1, q = l2, curr = dummyHead;
    int carry = 0;
    while (p != null || q != null) {
        int x = (p != null) ? p.val : 0;
        int y = (q != null) ? q.val : 0;
        int sum = carry + x + y;
        carry = sum / 10;
        curr.next = new ListNode(sum % 10);
        curr = curr.next;
        if (p != null) p = p.next;
        if (q != null) q = q.next;
    }
    if (carry > 0) {
        curr.next = new ListNode(carry);
    }
    return dummyHead.next;
}
    public static void main(String ...args) {
        System.out.println(Integer.MAX_VALUE);
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
