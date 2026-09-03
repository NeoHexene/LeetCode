class Node {

    int key;
    int val;
    int freq;
    Node next;
    Node prev;

    Node(int key, int val, int freq) {

        this.key = key;
        this.val = val;
        this.freq = freq;
        this.prev = null;
        this.next = null;
    }

}

class DLL {
    
    Node head;
    Node tail;
    int size;

    DLL() {

        this.head = new Node(-1, -1, -1);
        this.tail = new Node(-1, -1, -1);

        this.head.next = this.tail;
        this.tail.prev = this.head;

        this.size = 0;
    }

    void addFirst(Node newNode) {
        
        Node oldNext = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = oldNext;
        oldNext.prev = newNode;
        size++;
    }

    void remove(Node node) {

        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        size--;
    }

    //remove LRU
    Node removeLast() {
        
        if (size == 0) {
            return null;
        }

        Node lru = tail.prev;
        remove(lru);

        return lru;
    }

    boolean isEmpty() {
        return size == 0;
    }
}

class LFUCache {

    private Map<Integer, DLL> freq;
    private Map<Integer, Node> map;
    private int capacity;
    private int size;
    private int minFreq;



    public LFUCache(int capacity) {

        this.freq = new HashMap<>();
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 0;
    }

    public int get(int key) {
        
        if (map.containsKey(key)) {
            
            Node node = map.get(key);
            increaseFrequency(node);
            return node.val;
        }

        return -1;
    }

    public void put(int key, int value) {
        
        if (capacity == 0) {
            return;
        }

        if (map.containsKey(key)) {

            Node node = map.get(key);
            node.val = value;
            increaseFrequency(node);
            return;
        }

        if (size == capacity) {
            
            DLL list = freq.get(minFreq);
            Node lru = list.removeLast();
            map.remove(lru.key);
            size--;
        }

        Node newNode = new Node(key, value, 1);
        DLL dll = freq.computeIfAbsent(1, k -> new DLL());
        minFreq = 1;
        dll.addFirst(newNode);
        map.put(key, newNode);
        size++;
    }

    private void increaseFrequency(Node node) {
        
        int oldFreq = node.freq;
        DLL dll = freq.get(oldFreq);
        dll.remove(node);

        if (oldFreq == minFreq && dll.isEmpty()) {
            minFreq++;
        }

        node.freq++;

        DLL newDll = freq.computeIfAbsent(node.freq, k -> new DLL());

        newDll.addFirst(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */