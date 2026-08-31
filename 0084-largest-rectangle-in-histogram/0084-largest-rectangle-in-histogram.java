class Solution {
    public int largestRectangleArea(int[] heights) {

        Stack<Integer> st = new Stack<>();
        long maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                
                int num = heights[st.pop()];
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();

                maxArea = (long) Math.max(maxArea, 1l * num * (nse - pse - 1));
            }

            st.push(i);
        }

        while (!st.isEmpty()) {

            int num = heights[st.pop()];
            int nse = heights.length;
            int pse = st.isEmpty() ? -1 : st.peek();

            maxArea = (long) Math.max(maxArea, 1l * num * (nse - pse - 1));
        }

        return (int) maxArea;
    }
}