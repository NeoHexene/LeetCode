class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        Stack<Integer> st = new Stack<>();
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && prices[st.peek()] >= prices[i]) {
                int idx = st.pop();
                res[idx] = prices[idx] - prices[i];
            }
            st.push(i);
            res[i] = prices[i];
        }
        return res;
    }
}