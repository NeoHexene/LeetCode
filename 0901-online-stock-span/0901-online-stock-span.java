class StockSpanner {

    private int top;
    private Stack<int[]> st;

    public StockSpanner() {
        this.st = new Stack<>();
        this.top = -1;
    }
    
    public int next(int price) {
        while (!st.isEmpty() && st.peek()[0] <= price) {
            st.pop();
        }
        top += 1;
        int idx = st.isEmpty() ? -1 : st.peek()[1];
        st.push(new int[]{price, top});
        return top - idx;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */