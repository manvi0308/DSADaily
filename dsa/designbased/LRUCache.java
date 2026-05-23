package designbased;

import java.util.HashMap;
import java.util.HashSet;

public class LRUCache {
    // for O(1) lookups, use hashmap
    // for O(1) deletion, use doubly linked list
    private static class Node{
        int key, value;
        Node prev, next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final HashMap<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        if (!map.containsKey(key))
            return -1;
        Node node = map.get(key);
        remove(node); // detach from current position
        insertFront(node); // move to front
        return node.value;
    }
    public void put(int key, int value){
        if (map.containsKey(key))
            remove(map.get(key));
        Node node = new Node(key, value);
        map.put(key, node);
        insertFront(node);
        if (map.size() > capacity){
            Node lru = tail.prev;
            remove(lru);
            map.remove(lru.key);
        }
    }
    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void insertFront(Node node){
        node.next      = head.next;
        node.prev      = head;
        head.next.prev = node;
        head.next      = node;
    }
}
