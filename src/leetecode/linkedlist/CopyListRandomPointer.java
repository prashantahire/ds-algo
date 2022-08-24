package leetecode.linkedlist;

public class CopyListRandomPointer {
    public Node copyRandomList(Node head) {

        if(head == null)
            return head;

        Node current = head;
        while (current != null){
            Node n = new Node(current.val);
            Node temp = current.next;
            current.next = n;
            n.next = temp;
            current = temp;
        }

        current = head;
        while (current != null && current.next != null){
            if(current.random != null)
                current.next.random = current.random.next;
            current = current.next.next;
        }

        Node newHead = head.next;
        current = head;
        while (current != null && current.next != null){
            Node temp = current.next;
            current.next = temp.next;
            current = current.next;
            temp.next = current.next;
        }
        return newHead;
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}