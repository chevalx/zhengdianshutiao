package misc.design;

import java.util.*;

public class LRUCache {

    public static void main(String[] args) {
        Cache2 lRUCache = new Cache2(2);
        lRUCache.put(2,1);
        lRUCache.put(2,2);
        lRUCache.get(2);
        lRUCache.put(1,1);
        lRUCache.put(4,1);
        lRUCache.get(2);
    }
}


class Cache2 {
    class DLinkNode {
        int key;
        int value;
        DLinkNode prev;
        DLinkNode next;

        public DLinkNode () {

        }

        public DLinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, DLinkNode> cache = new HashMap<>();
    private int cacheSize;
    private int capacity;
    private DLinkNode head;
    private DLinkNode tail;
    public Cache2(int capacity) {
        // dummy head
        head = new DLinkNode();
        // dummy tail
        tail = new DLinkNode();
        head.next = tail;
        tail.prev = head;
        cacheSize = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            DLinkNode foundNode = cache.get(key);
            moveToHead(foundNode);
            return foundNode.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (!cache.containsKey(key)) {
            // 之前没有
            DLinkNode node = new DLinkNode(key, value);
            addToHead(node);
            cache.put(key, node);
            cacheSize++;
            if (cacheSize>capacity){
                DLinkNode removed = removeTail();
                cache.remove(removed.key);
                cacheSize--;
            }
        } else {
            // 之前有
            DLinkNode foundNode = cache.get(key);
            foundNode.value = value;
            moveToHead(foundNode);
        }
    }

    private DLinkNode removeTail() {
        DLinkNode lastOne = tail.prev;
        removeNode(lastOne);
        return lastOne;
    }

    private void moveToHead(DLinkNode node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(DLinkNode node) {
        head.next.prev = node;
        node.next = head.next;
        head.next = node;
        node.prev = head;
    }

    private void removeNode(DLinkNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
}

// 用hashmap 和双端队列超时
class Cache1 {
    private HashMap<Integer, Integer> map;
    private Deque<Integer> cache;
    private int capacity;


    public Cache1(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        cache = new ArrayDeque<>();
    }

    public int get(int key) {
        if (cache.contains(key)) {
            cache.removeLastOccurrence(key);
            cache.offerLast(key);
            return map.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (!cache.contains(key)) {
            // 之前没有
            map.put(key, value);
            cache.offerLast(key);
            if (cache.size() > capacity) {
                cache.pollFirst();
            }
        } else {
            // 之前有
            map.put(key, value);
            cache.removeLastOccurrence(key);
            cache.offerLast(key);
        }
    }
}
