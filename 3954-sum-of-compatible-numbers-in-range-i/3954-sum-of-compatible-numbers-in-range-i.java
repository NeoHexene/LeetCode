/*
x is +ve
abs(n - x) <= k
n & x == 0


range of x would be 1 to n + k
*/
class Solution {
    public int sumOfGoodIntegers(int n, int k) {
        int res = 0;
        for (int x = 1; x <= n + k; x++) {
            if((n & x) == 0 && Math.abs(n - x) <= k) {
                res += x;
            }
        }
        return res;
    }
}