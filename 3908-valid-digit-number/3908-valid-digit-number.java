class Solution {
    public boolean validDigit(int n, int x) {
        int lastOccurred = -1;
        boolean present = false;
        while (n > 0) {
            lastOccurred = n % 10;
            if (lastOccurred == x) {
                present = true;
            }
            n /= 10;
        }

        return lastOccurred != x && present;
    }
}