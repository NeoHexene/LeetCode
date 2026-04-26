/*
INTUITION:

We need to find the length of the longest contiguous sequence of 1s.

Key idea:
- Traverse the array
- Keep counting consecutive 1s
- Reset count when we see a 0
- Track the maximum count seen so far

-----------------------------------------------------

APPROACH:

1. Initialize:
   - count = 0 → current streak of 1s
   - max = 0 → maximum streak seen so far

2. Iterate through array:
   - If nums[i] == 1:
        → increment count
   - If nums[i] == 0:
        → update max
        → reset count to 0

3. After loop:
   - Do one final max update
   (in case array ends with 1s)

-----------------------------------------------------

EXAMPLE:

nums = [1,1,0,1,1,1]

Step-by-step:
count = 2 → hit 0 → max = 2, reset
count = 3 → end → max = 3

-----------------------------------------------------

EDGE CASES:

1. All 1s → handled by final max update
2. All 0s → max remains 0
3. Single element → works naturally

-----------------------------------------------------

TIME COMPLEXITY:
O(n)

SPACE COMPLEXITY:
O(1)

-----------------------------------------------------

PATTERN:

Linear scan + running count (streak tracking)
*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                // End of current streak
                max = Math.max(max, count);
                count = 0;
            } else {
                // Continue streak of 1s
                count++;
            }
        }

        // Final check (important if array ends with 1s)
        max = Math.max(max, count);

        return max;
    }
}