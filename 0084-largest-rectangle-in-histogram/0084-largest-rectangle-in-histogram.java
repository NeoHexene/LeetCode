class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int n = heights.length;
        int maxArea = 0;
        
        for (int i = 0; i < n; i++) {
            while(st.peek() != -1 && heights[i] <= heights[st.peek()]) {
                int height = heights[st.pop()];
                int width = i - st.peek() - 1;
                int currArea = height * width;
                if (currArea > maxArea) {
                    maxArea = currArea;
                }
            }
            st.push(i);
        }

        while (st.peek() != -1) {
            int height = heights[st.pop()];
            int width = heights.length - st.peek() - 1;
            int currArea = height * width;
            if (currArea > maxArea) {
                maxArea = currArea;
            }
        }

        return maxArea;
    }
}