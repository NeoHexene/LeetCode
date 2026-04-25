/*
INTUITION:

We need to check if the array is a rotated sorted array.

A rotated sorted array means:
- It was originally sorted in non-decreasing order
- Then rotated at some pivot

Example:
[1,2,3,4,5] → sorted
[3,4,5,1,2] → rotated sorted

Key observation:
    In a rotated sorted array, there can be at most ONE "drop"
    where nums[i-1] > nums[i]

-----------------------------------------------------

CORE IDEA:

Traverse the array and count how many times the order breaks:
- If it breaks more than once → NOT rotated sorted

Also:
- If there is a drop, then the last part must still be ≤ first element
  (to maintain rotation validity)

-----------------------------------------------------

WHAT YOUR CODE DOES:

1. Tracks whether a drop has occurred using `check`
2. If a second drop occurs → return false
3. After a drop:
   - ensures that all elements in the second part are ≤ nums[0]

-----------------------------------------------------

EDGE CASES:

1. Already sorted (no drop) → valid
2. Single element → valid
3. All equal → valid
4. More than one drop → invalid

-----------------------------------------------------

TIME COMPLEXITY:
O(n)

SPACE COMPLEXITY:
O(1)
*/

class Solution {
    public boolean check(int[] nums) {
        boolean check = false; // indicates whether a drop has been seen

        for (int i = 1; i < nums.length; i++) {

            // Detect a drop
            if (nums[i - 1] > nums[i] && !check) {
                check = true;
            } 
            // More than one drop → invalid
            else if (nums[i - 1] > nums[i] && check) {
                return false;
            }

            // After drop, elements must be <= first element
            if (check && nums[0] < nums[i]) {
                return false;
            }
        }

        return true;
    }
}