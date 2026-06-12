/*
x is +ve
abs(n - x) <= k
n & x == 0


range of x would be 1 to n + 2 * k
*/
class Solution {
    public int sumOfGoodIntegers(int n, int k) {
        int res = 0;
        for (int start = 1; start <= n + 2 * k; start++) {
            if((n & start) == 0 && Math.abs(n - start) <= k) {
                res += start;
            }
        }
        return res;
    }
}