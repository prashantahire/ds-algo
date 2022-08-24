package leetecode.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, SNode> cache;
    private int capacity;
    private SNode head;
    private SNode tail;

    public LRUCache(int capacity) {
        cache = new HashMap<>();
        this.capacity = capacity;
        head = new SNode(0, 0);
        tail = new SNode(0, 0);
        head.next = tail;
    }

    public int get(int key) {
        if(cache.get(key) == null) return -1;
        SNode node = cache.get(key);
        int res = node.value;
        removeNode(node);
        addToHead(node);
        return res;
    }

    public void put(int key, int value) {
        if(cache.get(key) != null){
            SNode node = cache.get(key);
            node.value = value;
            removeNode(node);
            addToHead(node);
        }else{
            SNode node = new SNode(key, value);
            cache.put(key, node);
            if(cache.size() <= capacity){
                addToHead(node);
            }else{
                SNode temp = head;
                while (temp.next != tail)
                    temp = temp.next;
                cache.remove(temp.key);
                removeNode(temp);
                addToHead(node);
            }
        }
    }

    private void removeNode(SNode node){
        SNode prev = null;
        SNode cur = head;
        while (cur != node){
            prev = cur;
            cur = cur.next;
        }
        prev.next = cur.next;
        cur.next = null;
    }

    private void addToHead(SNode node){
        SNode temp = head.next;
        head.next = node;
        node.next = temp;
    }

    public static void main(String ...args){
        LRUCache c = new LRUCache(3);
        c.put(1,1);
        c.put(2,2);
        c.put(3,3);
        c.put(4,4);
        System.out.println(c.get(4));
        System.out.println(c.get(3));
        System.out.println(c.get(2));
        System.out.println(c.get(1));
        c.put(5,5);
        System.out.println(c.get(1));
        System.out.println(c.get(2));
        System.out.println(c.get(3));
        System.out.println(c.get(4));
        System.out.println(c.get(5));


    }
}

class SNode{
     int key;
     int value;
     SNode next;
    public SNode(int key, int val){
        this.key = key;
        this.value = val;
    }
}
