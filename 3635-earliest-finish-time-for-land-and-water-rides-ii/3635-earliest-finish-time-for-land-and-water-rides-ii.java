class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minLand = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            minLand = Math.min(minLand, landStartTime[i] + landDuration[i]);
        }

        int ans = Integer.MAX_VALUE;

        int minWater = Integer.MAX_VALUE;
        for (int i = 0; i < waterStartTime.length; i++) {
            minWater = Math.min(minWater, waterStartTime[i] + waterDuration[i]);

            ans = Math.min(ans, Math.max(minLand, waterStartTime[i]) + waterDuration[i]);
        }

        for (int i = 0; i < landStartTime.length; i++) {
            ans = Math.min(ans, Math.max(minWater, landStartTime[i]) + landDuration[i]);
        }

        return ans;
    }
}