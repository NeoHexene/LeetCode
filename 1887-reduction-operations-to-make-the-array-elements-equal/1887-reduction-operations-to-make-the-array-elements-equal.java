class Solution {
    public int reductionOperations(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int curr = nums[nums.length - 1];
        int small = nums[0];
        if (curr == small) {
            return 0;
        }
        HashMap<Integer, Integer> count = new HashMap<>();
        count.put(curr, 1);
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < curr) {
                count.put(nums[i], count.get(curr) + 1);
                curr = nums[i];
            } else if (nums[i] == curr && nums[i] != small) {
                count.put(curr, count.getOrDefault(curr, 0) + 1);
            } else {
                continue;
            }
        }
        int ans = 0;
        for (Integer key : count.keySet()) {
            if (key != small) {
                ans += count.get(key);
            }
        }
        return ans;
    }
}