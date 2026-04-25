class Solution {
    public boolean check(int[] nums) {
        boolean check = false;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i] && !check) {
                check = true;
            } else if (nums[i - 1] > nums[i] && check) {
                return false;
            }
            if (check && nums[0] < nums[i]) {
                return false;
            }
        }
        return true;
    }
}