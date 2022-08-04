class Solution {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums); // sorts array in ascending order, so that 2 same numbers will come beside each other
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {  // to make i-1 valid, we started indexing from 1
                return nums[i];
            }
        }
        return -1;
    }
}