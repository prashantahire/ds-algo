package leetecode.design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {
//    private int capacity;
//    private CacheKey<Integer> head;
//    private Map<CacheKey<Integer>, Integer> cache;
//    private CacheKey<Integer> tail;
//
//    public LRUCache2(int capacity) {
//        cache = new HashMap<>();
//        this.capacity = capacity;
//    }
//
//    public void put(int key, int value) {
//        CacheKey ck = new CacheKey(key);
//        if(cache.isEmpty()){
//            cache.put(ck, value);
//            head = ck;
//            tail = ck;
//        }else if(cache.containsKey(ck)){
//            updateCache(key);
//            cache.put(ck, value);
//        }else if(cache.size() < capacity){
//            cache.put(ck, value);
//            CacheKey temp = head;
//            head = ck;
//            head.next = temp;
//        } else {
//            cache.remove(tail);
//            CacheKey current = head;
//            CacheKey prev = null;
//            while (current != tail){
//                prev = current;
//                current = current.next;
//            }
//            if(current == head) {
//                head = ck;
//                tail = ck;
//            }else{
//                prev.next = null;
//                tail = prev;
//                CacheKey temp = head;
//                head = ck;
//                head.next = temp;
//
//            }
//            cache.put(ck, value);
//        }
//    }
//    public int get(int key) {
//        if(cache.isEmpty()) return -1;
//
//        CacheKey ck = new CacheKey(key);
//        if(!cache.containsKey(ck)) return -1;
//        updateCache(key);
//        return cache.get(ck);
//    }
//
//    public void updateCache(int key){
//        CacheKey prev = null;
//        CacheKey current = head;
//        while (current != null){
//            if((Integer)current.val == key)
//                break;
//            prev = current;
//            current = current.next;
//        }
//        if(current == head) return;
//        if(current == tail){
//            tail = prev;
//        }
//        prev.next = current.next;
//        CacheKey temp = head;
//        head = current;
//        head.next = temp;
//    }
}
