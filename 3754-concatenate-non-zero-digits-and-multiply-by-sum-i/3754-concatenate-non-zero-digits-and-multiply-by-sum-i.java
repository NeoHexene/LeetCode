class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0;
        long num = 0;
        long mul = 1;
        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            if (digit != 0) {
                num = num + (mul * digit);
                mul *= 10;
            }
            n /= 10;
        }

        return num * sum;
    }
}