class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        int currRem = 1;
        int i = 1;
        while (i <= k) {
            currRem = currRem % k;
            if (currRem == 0) {
                return i;
            }
            currRem = currRem * 10 + 1;
            i++;
        }
        return i;
    }
}