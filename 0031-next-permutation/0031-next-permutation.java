/*
INTUITION:

We need to rearrange the array into the "next greater permutation" in lexicographic order.

Think of the array like a number:
- [1,2,3] -> next permutation is [1,3,2]
- [3,2,1] -> no greater permutation exists, so return the smallest one: [1,2,3]

The key idea is to change the array as little as possible while making it bigger.

-----------------------------------------------------

BRUTE FORCE APPROACH:

Generate all permutations, sort them lexicographically, and find the next one.

Time Complexity: O(n!)
Space Complexity: O(n)

This is too slow.

-----------------------------------------------------

OPTIMIZED APPROACH:

We use a greedy pattern:

1. Find the first index from the right where nums[i - 1] < nums[i]
   - This is called the "pivot"
   - Everything to the right of pivot is in descending order

2. If no such pivot exists:
   - The array is already the largest permutation
   - Reverse the whole array to get the smallest permutation

3. Otherwise:
   - Find the smallest number greater than nums[i - 1] in the suffix
   - Swap it with nums[i - 1]

4. Reverse the suffix
   - Because the suffix was descending, reversing it makes it ascending
   - This gives the smallest possible arrangement after the swap

-----------------------------------------------------

WHY THIS WORKS:

We want the next bigger permutation, not just any bigger permutation.

So:
- First, make the smallest possible increase at the pivot
- Then make the suffix as small as possible

That is exactly why we swap and then reverse the suffix.

-----------------------------------------------------

TIME COMPLEXITY:
O(n)

SPACE COMPLEXITY:
O(1)
*/

class Solution {
    public void nextPermutation(int[] nums) {

        // Step 1: Find the first decreasing element from the right
        // nums[i - 1] < nums[i] means we found a pivot
        int i = nums.length - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }

        // If no pivot exists, the array is in descending order
        // This is the largest permutation, so reverse it to get the smallest
        if (i == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        // Step 2: Find the rightmost element greater than pivot
        int j = nums.length - 1;
        while (j >= i && nums[j] <= nums[i - 1]) {
            j--;
        }

        // Step 3: Swap pivot with that element
        swap(nums, i - 1, j);

        // Step 4: Reverse the suffix to get the smallest arrangement
        reverse(nums, i, nums.length - 1);
    }

    // Reverse the subarray from start to end
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start += 1;
            end -= 1;
        }
    }

    // Swap two elements
    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}