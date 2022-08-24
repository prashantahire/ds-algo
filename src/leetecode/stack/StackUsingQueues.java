package leetecode.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
}

class MyStack {


    private Queue<Integer> q1;
    private Queue<Integer> q2;
    int top;
    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();

    }

    /** Push element x onto stack. */
    public void push(int x) {
        top = x;
        q1.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (q1.size()>1){
            top = q1.poll();
            q2.offer(top);
        }
        int val = q1.poll();
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
        return val;
    }

    /** Get the top element. */
    public int top() {
        return top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}

class MyStack_SingleQueue {


    private Queue<Integer> q1;
    int top;
    /** Initialize your data structure here. */
    public MyStack_SingleQueue() {
        q1 = new LinkedList<>();

    }

    /** Push element x onto stack. */
    public void push(int x) {
        q1.offer(x);
        int sz = q1.size();
        while (sz > 1){
            q1.offer(q1.poll());
            sz--;
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.poll();
    }

    /** Get the top element. */
    public int top() {
        return q1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
}