class Solution {
    public int minimumPrefixLength(int[] nums) {
        int size = -1;
        for (int i = 0, j = 1; j < nums.length; i++, j++) {
            if (nums[i] >= nums[j]) {
                size = i;
            }
        }
        return size == -1 ? 0 : size + 1;
    }
}