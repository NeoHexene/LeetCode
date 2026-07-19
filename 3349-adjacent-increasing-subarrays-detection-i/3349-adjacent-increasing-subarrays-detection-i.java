class Solution {

    private boolean isNonDecreasing(List<Integer> arr, int start, int end) {
        while (start < end) {
            if (arr.get(start) >= arr.get(start + 1)) {
                return false;
            }
            start += 1;
        }
        return true;
    }

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int i = 0, j = 2 * k - 1;
        while (j < nums.size()) {
            if (isNonDecreasing(nums, i, i + k - 1) && isNonDecreasing(nums, i + k, j)) {
                return true;
            }
            i++;
            j++;
        }
        return false;
    }
}