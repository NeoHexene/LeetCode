class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {

    private int cap;
    private Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.head = new Node (-1, -1);
        this.tail = new Node (-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if (cache.containsKey(key)) {
            Node newNode = cache.get(key);
            delete(newNode);
            insert(newNode);
            return newNode.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            delete(cache.get(key));
        }
        Node newNode = new Node(key, value);
        insert(newNode);
        cache.put(key, newNode);
        if (cache.size() > cap) {
            Node lru = tail.prev;
            delete(lru);
            cache.remove(lru.key);
        }
        return;
    }

    private void insert(Node newNode) {
        Node oldNext = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = oldNext;
        oldNext.prev = newNode;
    }

    private void delete(Node existingNode) {
        Node prevNode = existingNode.prev;
        Node nextNode = existingNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */