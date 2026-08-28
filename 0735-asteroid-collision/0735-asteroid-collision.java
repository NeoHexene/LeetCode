class Solution {

    private boolean isOpp(int top, int curr) {
        return top < 0 && curr > 0;
    }

    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();

        for (int i = asteroids.length - 1; i >= 0; i--) {
            
            int curr = asteroids[i];
            boolean skipCurr = false;

            while (!st.isEmpty() && isOpp(st.peek(), curr)) {
                if (Math.abs(st.peek()) == Math.abs(curr)) {
                    st.pop();
                    skipCurr = true;
                    break;
                } else if (Math.abs(st.peek()) > Math.abs(curr)) {
                    skipCurr = true;
                    break;
                }
                st.pop();
            }

            if (skipCurr) {
                continue;
            }

            st.push(curr);
        }

        int[] res = new int[st.size()];
        int idx = 0;

        while (!st.isEmpty()) {
            res[idx++] = st.pop();
        }

        return res;
    }
}