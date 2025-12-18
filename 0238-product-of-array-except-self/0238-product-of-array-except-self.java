class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int countZero = 0;
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                countZero++;
            } else {
                product *= nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (countZero > 0) {
                    ans[i] = 0;
                } else {
                    ans[i] = product / nums[i];
                }
            } else {
                if (countZero > 1) {
                    ans[i] = 0;
                } else {
                    ans[i] = product;
                }
            }
        }
        return ans;
    }
}