class Solution {

    private int countSubArraysWithLessThanEqualSum(int[] nums, int goal) {

        if (goal < 0) {
            return 0;
        }

        int l = 0, r = 0, count = 0, sum = 0;

        while (r < nums.length) {
            
            sum += nums[r];

            while (sum > goal) {
                sum -= nums[l];
                l++;
            }

            count += r - l + 1;

            r++;
        }

        return count;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        
        int res = countSubArraysWithLessThanEqualSum(nums, goal) - countSubArraysWithLessThanEqualSum(nums, goal - 1);

        return res;
    }
}