class Solution {

    private int helper (int l, int r, int[] nums) {
        if (l == r) {
            return nums[r];
        }
        l++;
        while (l <= r) {
            if ((nums[l] <= nums[l - 1]) || (nums[l] - nums[l - 1] != 1)) {
                return -1;
            }
            l++;
        }
        return nums[r];
    }

    public int[] resultsArray(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];

        int l = 0, r = k - 1, idx = 0;

        while (r < nums.length) {
            res[idx++] = helper(l, r, nums);
            l++;
            r++;
        }

        return res;
    }
}