class Solution {

    private int[] nextSmallerElements(int[] nums) {

        Stack<Integer> st = new Stack<>();
        int[] res = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            res[i] = st.isEmpty() ? nums.length : st.peek();
            st.push(i);
        }

        return res;
    }

    private int[] nextGreaterElements(int[] nums) {

        Stack<Integer> st = new Stack<>();
        int[] res = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            res[i] = st.isEmpty() ? nums.length : st.peek();
            st.push(i);
        }

        return res;
    }

    private int[] prevSmallerEqualElements(int[] nums) {

        Stack<Integer> st = new Stack<>();
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }

            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return res;
    }

    private int[] prevGreaterEqualElements(int[] nums) {

        Stack<Integer> st = new Stack<>();
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }

            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return res;
    }

    private long sumSubarrayMins(int[] nums) {

        int[] psee = prevSmallerEqualElements(nums);
        int[] nse = nextSmallerElements(nums);
        long total = 0;

        for (int i = 0; i < nums.length; i++) {

            int left = i - psee[i];
            int right = nse[i] - i;

            total += (1l * left * right * nums[i]);
        }

        return total;

    }

    private long sumSubarrayMaxs(int[] nums) {

        int[] nge = nextGreaterElements(nums);
        int[] pgee = prevGreaterEqualElements(nums);
        long total = 0;

        for (int i = 0; i < nums.length; i++) {

            int left = i - pgee[i];
            int right = nge[i] - i;

            total += (1l * left * right * nums[i]);
        }

        return total;

    }

    public long subArrayRanges(int[] nums) {
        
        long maxSum = sumSubarrayMaxs(nums);
        long minSum = sumSubarrayMins(nums);

        return maxSum - minSum;
    }
}