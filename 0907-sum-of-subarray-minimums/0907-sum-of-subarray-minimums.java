class Solution {

    private final int MOD = 1000000007;

    private int[] nextSmallerElements(int arr[]) {

        int n = arr.length;

        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }

            res[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        return res;

    }

    private int[] previousSmallerEqualElements(int arr[]) {
        
        int n = arr.length;

        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }

            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return res;

    }

    public int sumSubarrayMins(int[] arr) {
        
        long total = 0;

        int[] psee = previousSmallerEqualElements(arr);
        int[] nse = nextSmallerElements(arr);

        for (int i = 0; i < arr.length; i++) {

            int npsee = i - psee[i];
            int nnse = nse[i] - i;

            total = (total + (int) (1l * arr[i] * nnse * npsee % MOD)) % MOD;
        }

        return (int) total;
    }
}