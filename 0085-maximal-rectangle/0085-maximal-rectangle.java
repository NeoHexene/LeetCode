class Solution {

    private int maxRectangleInHistogram(int[] nums) {

        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < nums.length; i++) {
        
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
        
                int n = nums[st.pop()];
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();

                maxArea = Math.max(maxArea, n * (nse - pse - 1));
            }

            st.push(i);
        }

        while (!st.isEmpty()) {

            int n = nums[st.pop()];
            int nse = nums.length;
            int pse = st.isEmpty() ? -1 : st.peek();

            maxArea = Math.max(maxArea, n * (nse - pse - 1));
        }

        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        
        int[] nums = new int[matrix[0].length];
        int maxRec = 0;

        for (char row[] : matrix) {
            for (int i = 0; i < row.length; i++) {
                
                if (row[i] == '0') {
                
                    nums[i] = 0;
                } else {

                    nums[i] += 1;
                }

            }
            maxRec = Math.max(maxRec, maxRectangleInHistogram(nums));
        }

        return maxRec;
    }
}