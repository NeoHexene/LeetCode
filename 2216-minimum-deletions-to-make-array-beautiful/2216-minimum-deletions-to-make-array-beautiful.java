class Solution {
    public int minDeletion(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                i++;
            } else {
                count++;
            }
        }
        if ((nums.length - count) % 2 != 0) {
            count += 1;
        }
        return count;
    }
}