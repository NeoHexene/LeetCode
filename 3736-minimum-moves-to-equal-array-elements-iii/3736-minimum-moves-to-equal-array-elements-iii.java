class Solution {
    public int minMoves(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int target = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if (target < nums[i]) {
                target = nums[i];
            }
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (target - nums[i]);
        }
        return sum;
    }
}