class Solution {

    private int countOfSubarraysLessThanOrEqualToK(int[] nums, int k) {

        if (k < 0) {
            return 0;
        }

        int l = 0, r = 0, count = 0, odds = 0;

        while (r < nums.length) {
            
            if (nums[r] % 2 != 0) {
                odds++;
            }

            while (odds > k) {
                if (nums[l] % 2 != 0) {
                    odds--;
                }
                l++;
            }

            count += (r - l + 1);

            r++;
        }

        return count;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        
        int res = countOfSubarraysLessThanOrEqualToK(nums, k) - countOfSubarraysLessThanOrEqualToK(nums, k - 1);

        return res;

    }
}