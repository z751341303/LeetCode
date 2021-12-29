import java.util.HashMap;

/*
146.LRU缓存机制
https://leetcode-cn.com/problems/lru-cache/
 */

public class LC_146_LRU {

    private HashMap<Integer, Node> hashmap;
    private DoubleList cache;
    private int cap;

    public LC_146_LRU(int capacity) {
        cap = capacity;
        hashmap = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!hashmap.containsKey(key)) {
            return -1;
        }
        int val = hashmap.get(key).val;
        put(key, val);
        return val;
    }

    public void put(int key, int val) {
        Node temp = new Node(key, val);
        if (hashmap.containsKey(key)) {
            cache.remove(hashmap.get(key));
            cache.addFirst(temp);
            hashmap.put(key, temp);
        } else {
            if (cap == cache.size()) {
                Node last = cache.removeLast();
                hashmap.remove(last.key);
            }
            cache.addFirst(temp);
            hashmap.put(key, temp);
        }
    }
}

class Node
{
    public int key, val;
    public Node next, prev;
    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

// 构造双向链表

class DoubleList {
    private Node head, tail; // 头尾虚节点
    private int size; // 链表元素数

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // 在链表头部添加节点 x
    public void addFirst(Node x) {
        x.next = head.next;
        x.prev = head;
        head.next.prev = x;
        head.next = x;
        size++;
    }

    // 删除链表中的 x 节点（x 一定存在）
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    // 删除链表中最后一个节点，并返回该节点
    public Node removeLast() {
        if (tail.prev == head)
            return null;
        Node last = tail.prev;
        remove(last);
        return last;
    }

    // 返回链表长度
    public int size() { return size; }
}