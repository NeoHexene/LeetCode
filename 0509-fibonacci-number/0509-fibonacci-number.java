class Solution {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int prev1 = 0;
        int prev2 = 1;
        int i = 2;
        while (i <= n) {
            int curr = prev1 + prev2;
            prev1 = prev2;
            prev2 = curr;
            i++;
        }
        return prev2;
    }
}