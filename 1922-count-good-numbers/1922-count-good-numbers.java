class Solution {

    private final int MOD = 1_000_000_007;

    private long helper(long x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        if (n % 2 == 0) {
            return helper(x * x % MOD, n / 2) ;
        } else {
            return x * helper(x * x  % MOD, (n - 1) / 2) % MOD;
        }
    }

    public int countGoodNumbers(long n) {
        long fours = n / 2;
        long fives = n - fours;

        return (int)(helper(5l, fives) * helper(4l, fours) % MOD);
    }
}