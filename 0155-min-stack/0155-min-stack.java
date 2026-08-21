class ListNode {
    int val;
    ListNode prev;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class MinStack {

    private PriorityQueue<ListNode> pq;
    private ListNode top;

    public MinStack() {
        pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        top = null;
    }
    
    public void push(int value) {
        ListNode newNode = new ListNode(value);
        pq.offer(newNode);
        if (top != null) {
            top.prev = newNode;
            newNode.next = top;
        }
        top = newNode;
    }
    
    public void pop() {
        ListNode temp = top;
        pq.remove(temp);
        top = top.next;
        if (top != null) {
            top.prev = null;
            temp.next = null;        
        }
    }
    
    public int top() {
        return top.val;
    }
    
    public int getMin() {
        return pq.peek().val;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */