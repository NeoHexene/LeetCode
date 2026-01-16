class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        Arrays.sort(nums);
        for (int num : nums) {
            if (freq.get(num) > 0) {
                for (int i = num + 1; i < num + k; i++) {
                    if (freq.getOrDefault(i, 0) == 0) {
                        return false;
                    }
                    freq.put(i, freq.get(i) - 1);
                }
                freq.put(num, freq.get(num) - 1);
            }
        }
        return true;
    }
}