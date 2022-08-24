package leetecode.design;

public class MinStack {

    StackNode head;
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if(head == null){
            this.head = new StackNode(x, x, null);
        }else{
            this.head = new StackNode(x, Math.min(x, this.head.min), this.head);
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}

class StackNode{
    int min;
    int val;
    StackNode next;

    StackNode(int val, int min, StackNode next){
        this.val = val;
        this.min = min;
        this.next = next;
    }
}
