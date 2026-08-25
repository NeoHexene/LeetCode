class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        Stack<Integer> st = new Stack<>();

        int[] res = new int[n];

        for (int i = 2 * n - 1; i >= 0; i--) {
            
            int idx = i % n;

            while (!st.isEmpty() && st.peek() <= nums[idx]) {
                st.pop();
            }

            if (i < n) {
                if (st.isEmpty()) {
                    res[i] = -1;
                } else {
                    res[i] = st.peek();
                }
            }

            st.push(nums[idx]);
        }

        return res;

    }
}