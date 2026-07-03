class Solution {

    private boolean safe(int[] nums, int threshold, int div) {
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] / div);
            if (nums[i] % div != 0) {
                sum += 1;
            }
        }

        return sum <= threshold;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = 0;
        for (int i = 0; i < nums.length; i++) {
            high = Math.max(nums[i], high);
        }
        
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (safe(nums, threshold, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}