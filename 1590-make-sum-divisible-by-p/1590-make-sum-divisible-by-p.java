class Solution {
    public int minSubarray(int[] nums, int p) {
        long totalSum = 0;
        for (int n : nums) {
            totalSum += n;
        }
        long rem = totalSum % p;
        if (rem == 0) {
            return 0;
        }
        Map<Long, Integer> prefMod = new HashMap<>();
        prefMod.put(0l, -1);
        long pref = 0;
        int minLen = nums.length;
        for (int i = 0; i < nums.length; i++) {
            pref += nums[i];
            long currRem = pref % p;
            long targetRem = (currRem - rem + p) % p;
            if (prefMod.containsKey(targetRem)) {
                minLen = Math.min(minLen, i - prefMod.get(targetRem));
            }
            prefMod.put(currRem, i);
        }
        return minLen == nums.length ? -1 : minLen;
    }
}