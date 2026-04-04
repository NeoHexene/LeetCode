class Solution {

    /*
    INTUITION:
    We need to find all unique triplets such that:
        nums[i] + nums[j] + nums[k] == 0

    Brute force checks every triplet, which is too slow: O(n^3).

    Better idea:
    1. Sort the array.
    2. Fix one number nums[i].
    3. Now the problem becomes finding two numbers in the बाकी part
       such that their sum is -nums[i].

    Since the array is sorted:
    - If the sum is too small, move the left pointer forward.
    - If the sum is too big, move the right pointer backward.

    To avoid duplicate triplets:
    - Skip repeated values of nums[i]
    - After finding a valid triplet, skip repeated left/right values too
    */

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        // Sort first so we can use two pointers
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate first numbers
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    // Found one valid triplet
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // Move both pointers
                    j++;
                    k--;

                    // Skip duplicate values on the left
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }

                    // Skip duplicate values on the right
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }

                } else if (sum < 0) {
                    // Sum is too small, need a bigger number
                    j++;
                } else {
                    // Sum is too large, need a smaller number
                    k--;
                }
            }
        }

        return res;
    }
}