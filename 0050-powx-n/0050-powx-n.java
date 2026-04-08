class Solution {
    public double myPow(double x, int n) {
        return helper(x, (long) n);
    }

    private double helper (double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n < 0) {
            return 1/helper(x, -n);
        }
        if (n % 2 == 0) {
            return helper(x * x, n / 2);
        }
        return x * helper(x * x, (n - 1) / 2);
    }
}