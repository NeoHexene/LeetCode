/*
INTUITION:
We need to support two operations efficiently:
1. get(key)   -> return value if present
2. put(key,v) -> insert/update the key with value

And when the cache exceeds capacity, we must remove the Least Recently Used (LRU) item.

To do this in O(1), we combine:
- HashMap: gives direct access to a node by key in O(1)
- Doubly Linked List: lets us remove and move nodes in O(1)

The doubly linked list stores items in usage order:
- Most recently used node is near the head
- Least recently used node is near the tail

So:
- On get(key): move that node to the front
- On put(key, value): insert at front
- If capacity is exceeded: remove node from the tail

-----------------------------------------------------

BRUTE FORCE APPROACH:

A simple brute force way would be:
- Store all elements in a list or array
- On every get, scan to find the key
- On every put, scan to update or remove the LRU item

Time Complexity:
- get: O(n)
- put: O(n)

This is too slow for the LRU Cache problem.

-----------------------------------------------------

OPTIMIZED APPROACH:

Use:
1. HashMap<Integer, Node>
   - key -> node mapping
   - lets us access nodes instantly

2. Doubly Linked List
   - keeps recent usage order
   - supports delete and insert in O(1)

We use two dummy nodes:
- head dummy
- tail dummy

This avoids edge cases when inserting or deleting from empty/one-element list.

Operations:
- insert(node): add node right after head
- delete(node): remove node from its current position

-----------------------------------------------------

IMPLEMENTED LOGIC:

get(key):
- If key exists:
  - remove node from current position
  - insert it at front
  - return its value
- Else return -1

put(key, value):
- If key already exists:
  - delete old node from list
- Create a new node
- Insert it at front
- Store it in the map
- If size exceeds capacity:
  - remove LRU node = tail.prev
  - delete it from list
  - remove from map

-----------------------------------------------------

TIME COMPLEXITY:
- get: O(1)
- put: O(1)

SPACE COMPLEXITY:
- O(capacity)
*/

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

        // Dummy head and tail nodes
        // head <-> ... <-> tail
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        // If key exists, move node to front and return value
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            delete(node);   // remove from current position
            insert(node);   // insert at front as most recently used
            return node.val;
        }

        // Key not found
        return -1;
    }

    public void put(int key, int value) {
        // If key already exists, remove the old node first
        if (cache.containsKey(key)) {
            delete(cache.get(key));
        }

        // Create a new node and insert it at the front
        Node newNode = new Node(key, value);
        insert(newNode);
        cache.put(key, newNode);

        // If capacity is exceeded, remove least recently used node
        if (cache.size() > cap) {
            Node lru = tail.prev;   // node just before dummy tail
            delete(lru);
            cache.remove(lru.key);
        }
    }

    private void insert(Node newNode) {
        // Insert right after head
        Node oldNext = head.next;

        head.next = newNode;
        newNode.prev = head;

        newNode.next = oldNext;
        oldNext.prev = newNode;
    }

    private void delete(Node existingNode) {
        // Remove node from its current position
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