/*
x is +ve
abs(n - x) <= k
n & x == 0


range of x would be 1 to n + k
*/
class Solution {
    public int sumOfGoodIntegers(int n, int k) {
        int end = n + 2 * k;
        int start = 1;
        int res = 0;
        while (start <= end) {
            if (Math.abs(n - start) <= k && (n & start) == 0) {
                res += start;
            }
            start++;
        }
        return res;
    }
}