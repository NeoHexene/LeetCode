/*
INTUITION:

We need to rotate the array to the right by k steps.

Example:
nums = [1,2,3,4,5,6,7], k = 3
result = [5,6,7,1,2,3,4]

Key idea:
Instead of shifting elements one by one (which is O(n*k)),
we can use the REVERSE technique.

-----------------------------------------------------

CORE IDEA (3 REVERSES):

1. Reverse the entire array
2. Reverse the first k elements
3. Reverse the remaining n-k elements

-----------------------------------------------------

WHY THIS WORKS:

Original:
[1, 2, 3, 4, 5, 6, 7]

Step 1 (reverse whole):
[7, 6, 5, 4, 3, 2, 1]

Step 2 (reverse first k=3):
[5, 6, 7, 4, 3, 2, 1]

Step 3 (reverse rest):
[5, 6, 7, 1, 2, 3, 4]

-----------------------------------------------------

IMPORTANT DETAIL:

k = k % n
→ handles cases where k > n

-----------------------------------------------------

EDGE CASES:

1. k = 0 → no rotation
2. k > n → handled using modulo
3. n = 1 → no change
4. k = n → same array

-----------------------------------------------------

TIME COMPLEXITY:
O(n)

SPACE COMPLEXITY:
O(1) (in-place)

-----------------------------------------------------

PATTERN:

Array reversal + in-place manipulation
*/

class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;

        // Handle k > n
        k = k % n;

        // Step 1: reverse entire array
        swap(nums, 0, n - 1);

        // Step 2: reverse first k elements
        swap(nums, 0, k - 1);

        // Step 3: reverse remaining elements
        swap(nums, k, n - 1);
    }

    // Helper function to reverse part of array
    private void swap(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }
}