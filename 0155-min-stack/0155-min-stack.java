class MinStack {

    private Stack<Long> st;
    private long min;

    public MinStack() {
        st = new Stack<>();
        min = Long.MAX_VALUE;
    }
    
    public void push(int value) {
       if (value < min) {
            st.push((long) 2 * value - min);
            min = value;
        } else {
            st.push((long) value);
        }
    }
    
    public void pop() {
        long pop = st.pop();
        if (pop < min) {
            min = 2 * min - pop;
        }
    }
    
    public int top() {
        if (st.peek() < min) {
            return (int) min;
        }
        return (int) (long) st.peek();
    }
    
    public int getMin() {
        if (st.isEmpty()) {
            return -1;
        }
        return (int) min;
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