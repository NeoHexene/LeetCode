class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n = temp.length;
        Stack<Integer> st = new Stack<>();
        int result[] = new int[n];
        for (int i = 0; i < n; i++) {
            while(!st.isEmpty() && temp[st.peek()] < temp[i]) {
                int idx = st.pop();
                result[idx] = i - idx;
            }
            st.push(i);
            result[i] = 0;
        }
        return result;
    }
}