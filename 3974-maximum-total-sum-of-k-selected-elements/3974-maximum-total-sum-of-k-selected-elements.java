class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        
        Arrays.sort(nums);

        long total = 0;
        
        for (int i = nums.length - 1; k > 0; i--, k--, mul--) {
            total += Math.max((long) nums[i],(long) nums[i] * mul);
        }

        return total;
    }
}