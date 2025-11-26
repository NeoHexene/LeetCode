class Solution {
    public int smallestRepunitDivByK(int k) {
        if (k % 2 == 0) {
            return -1;
        }
        Set<Integer> remSet = new HashSet<>();
        int currRem = 1;
        List<Integer> list = new ArrayList<>();
        while (list.size() <= k) {
            list.add(1);
            currRem = currRem % k;
            if (currRem == 0) {
                break;
            } else {
                if (remSet.contains(currRem)) {
                    return -1;
                }
                remSet.add(currRem);
            }
            currRem = currRem * 10 + 1;
        }
        return list.size();
    }
}