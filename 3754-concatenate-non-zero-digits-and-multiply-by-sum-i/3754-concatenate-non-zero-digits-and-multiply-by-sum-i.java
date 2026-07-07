class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0;
        String num = "";
        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            if (digit != 0) {
                num = digit + num;
            }
            n /= 10;
        }

        return Long.parseLong("0" + num) * sum;
    }
}