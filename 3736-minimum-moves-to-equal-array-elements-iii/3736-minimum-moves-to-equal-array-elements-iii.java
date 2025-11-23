class Solution {
    public int minMoves(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int target = nums[nums.length - 1];
        int sum = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            sum += (target - nums[i]);
        }
        return sum;
    }
}