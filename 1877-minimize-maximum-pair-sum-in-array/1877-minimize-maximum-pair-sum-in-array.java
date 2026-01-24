class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        long maxSum = 0;
        while (i < j) {
            maxSum = Math.max(maxSum, nums[i++] + nums[j--]);
        }
        return (int)maxSum;
    }
}