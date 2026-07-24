class Solution {
    public int smallestBalancedIndex(int[] nums) {
        long[] presum = new long[nums.length + 1];
        presum[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            presum[i + 1] = presum[i] + nums[i];
        }
        long[] sufprod = new long[nums.length + 1];
        sufprod[nums.length] = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (sufprod[i + 1] > (presum[nums.length] + 1) / nums[i]) {
                sufprod[i] = presum[nums.length] + 1;
            } else {
                sufprod[i] = sufprod[i + 1] * nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (presum[i] == sufprod[i+1]) {
                return i;
            }
        }
        return -1;
    }
}