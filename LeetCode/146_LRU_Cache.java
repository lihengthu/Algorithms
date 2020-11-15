// 1. LinkedHashMap
public class LRUCache {
    private int capa;
    private Map<Integer, Integer> map;

    public LRUCache(int capacity) {
        this.capa = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        int val = map.remove(key);
        map.put(key, val);

        return val;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
            return;
        }

        map.put(key, value);
        if (map.size() > this.capa) {
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }
}

// 2. HashMap + Single Linked List
public class LRUCache {
    class ListNode {
        int key, val;
        ListNode next;

        public ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
        }
    }

    private int capacity, size;
    private Map<Integer, ListNode> keyToPrev;
    private ListNode dummy, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.keyToPrev = new HashMap<>();
        this.dummy = new ListNode(0, 0);
        this.tail = dummy;

    }

    private void moveToTail(int key) {
        ListNode prev = keyToPrev.get(key);
        ListNode curr = prev.next;

        if (tail == curr) {
            return;
        }

        prev.next = prev.next.next;
        tail.next = curr;
        curr.next = null;


        if (prev.next != null) {
            keyToPrev.put(prev.next.key, prev);
        }

        keyToPrev.put(curr.key, tail);
        tail = curr;
    }

    public int get(int key) {
        if (!keyToPrev.containsKey(key)) {
            return -1;
        }
        moveToTail(key);
        return tail.val;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            ListNode prev = keyToPrev.get(key);
            prev.next.val = value;
            return;
        }

        if (size < capacity) {
            size++;
            ListNode curr = new ListNode(key, value);
            tail.next = curr;
            keyToPrev.put(key, tail);
            tail = curr;
            return;
        }

        ListNode first = dummy.next;
        keyToPrev.remove(first.key);
        first.key = key;
        first.val = value;
        keyToPrev.put(key, dummy);
        moveToTail(key);
    }
}
