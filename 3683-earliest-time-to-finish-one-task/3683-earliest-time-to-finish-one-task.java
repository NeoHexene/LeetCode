class Solution {
    public int earliestTime(int[][] tasks) {
        int currMin = Integer.MAX_VALUE;

        for (int[] curr : tasks) {
            currMin = Math.min(currMin, curr[0] + curr[1]);
        }
        
        return currMin;
    }
}