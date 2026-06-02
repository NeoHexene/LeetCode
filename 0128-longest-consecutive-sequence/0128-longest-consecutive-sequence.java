class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
            max = Math.max(max, nums[i]);
        }
        int maxLen = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int len = 1;
                int curr = n;
                while (set.contains(curr + 1)) {
                    curr++;
                    len++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}