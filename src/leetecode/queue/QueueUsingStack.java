package leetecode.queue;

import java.util.Stack;

public class QueueUsingStack {
    class MyQueue {

        Stack<Integer> s1;
        Stack<Integer> s2;
        int front = -1;
        /** Initialize your data structure here. */
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            if(front == -1)
                front = x;
            s1.push(x);
        }
        public void pushImproved(int x) {
            if(s1.isEmpty())
                front = x;
            s1.push(x);
        }
        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            int ele = s2.pop();
            if(!s2.isEmpty())
                front = s2.peek();
            else
                front=-1;
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
            return ele;
        }

        //Ammortized O(1)
        public int popImproved() {
            if(s2.isEmpty()){
                while (!s1.isEmpty())
                    s2.push(s1.pop());
            }
            return s2.pop();
        }
        /** Get the front element. */
        public int peek() {
            return front;
        }

        public int peekImproved() {
            if(!s2.isEmpty())
                return s2.peek();
            return front;
        }
        /** Returns whether the queue is empty. */
        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }
}
