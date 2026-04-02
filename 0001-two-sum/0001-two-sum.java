class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complement = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (complement.containsKey(diff)) {
                return new int[]{complement.get(diff), i};
            }
            complement.put(nums[i], i);
        }

        return new int[]{};
    }
}