class Solution {
    public boolean judgeSquareSum(int c) {
        long left = 0l;
        long right = (long) Math.sqrt(c);
        while (left <= right) {
            long prod = left * left + right * right;
            if (prod == c) {
                return true;
            }
            if (prod > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}