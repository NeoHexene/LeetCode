class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) {
            return -1;
        }
        Set<Integer> remSet = new HashSet<>();
        int currRem = 1;
        int i = 1;
        while (i <= k) {
            currRem = currRem % k;
            if (currRem == 0) {
                return i;
            } else {
                if (remSet.contains(currRem)) {
                    return -1;
                }
                remSet.add(currRem);
            }
            currRem = currRem * 10 + 1;
            i++;
        }
        return i;
    }
}