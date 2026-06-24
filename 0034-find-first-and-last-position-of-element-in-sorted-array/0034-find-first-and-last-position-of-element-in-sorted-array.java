class Solution {

    // lower-bound means a[i] >= target
    private int lowerBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = high + 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                ans = Math.min(ans, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    // upper-bound means a[i] > target
    private int upperBound(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = high + 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > target) {
                ans = Math.min(ans, mid);
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int lb = lowerBound(nums, target);
        int ub = upperBound(nums, target);

        if (lb == nums.length || nums[lb] != target) {
            return new int[]{-1, -1};
        }

        return new int[]{lb, ub - 1};
    }
}