class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int count = 0;
        int total = 0;
        for (int i = cost.length - 1; i >= 0; i--) {
            if (count != 0 && count % 2 == 0) {
                count = 0;
                continue;
            }
            count += 1;
            total += cost[i];
        }
        return total;
    }
}