class Solution {
    public int minimumIndex(int[] capacity, int itemsize) {
        int idx = -1;
        int minCap = 101;
        for (int i = 0; i < capacity.length; i++) {
            if (capacity[i] >= itemsize && minCap > capacity[i]) {
                idx = i;
                minCap = capacity[i];
            }
        }
        return idx;
    }
}