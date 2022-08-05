class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int a = n-1;
        while (a > 0) {
            if (nums[a] > nums[a-1]) { // if array is not in descending order then break (remember we are checking this in reverse order)
                break;
            }
            a--;
        }
        // if a becomes 0 that means array is in descending order
        if (a == 0) {
            Arrays.sort(nums);
            return;
        }
        a--; // decrement a since we checked nums[a] with nums[a-1] and hence we found nums[a] > nums[a-1]
        int s = n-1;
        while (s > 0 && nums[a] >= nums[s]) {
            s--;
        }
        int temp = nums[a];
        nums[a] = nums[s];
        nums[s] = temp;
        Arrays.sort(nums, a+1, nums.length);
    }
}