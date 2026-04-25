/*
INTUITION:

We want to move all 0s to the end while maintaining the relative order of non-zero elements.

Key idea:
- Use two pointers
- One pointer (i) tracks where the next non-zero should go
- Another pointer (j) scans the array

Whenever we find a non-zero at j:
→ place it at position i
→ move i forward

This effectively "compacts" all non-zero elements to the front.

-----------------------------------------------------

SIMPLER AND STANDARD APPROACH:

Instead of checking nums[i] repeatedly, do:

- If nums[j] != 0:
    → swap nums[i] and nums[j]
    → increment i

-----------------------------------------------------

EXAMPLE:

nums = [0,1,0,3,12]

j=0 → 0 → skip
j=1 → 1 → swap with nums[0] → [1,0,0,3,12], i=1
j=2 → 0 → skip
j=3 → 3 → swap → [1,3,0,0,12], i=2
j=4 → 12 → swap → [1,3,12,0,0]

-----------------------------------------------------

TIME COMPLEXITY:
O(n)

SPACE COMPLEXITY:
O(1)

-----------------------------------------------------

PATTERN:

Two pointers (slow + fast) for in-place array rearrangement
*/

class Solution {
    public void moveZeroes(int[] nums) {

        int i = 0; // position to place next non-zero

        for (int j = 0; j < nums.length; j++) {

            if (nums[j] != 0) {
                // swap nums[i] and nums[j]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
            }
        }
    }
}