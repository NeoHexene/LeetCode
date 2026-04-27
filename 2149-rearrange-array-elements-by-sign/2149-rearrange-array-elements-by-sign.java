/*
INTUITION:

We are given an array with equal number of positive and negative numbers.

Goal:
- Rearrange such that:
    → positive numbers are at even indices (0,2,4,...)
    → negative numbers are at odd indices (1,3,5,...)
- Maintain relative order is NOT required (but this approach preserves it anyway)

-----------------------------------------------------

CORE IDEA:

Use two pointers:
- pos → next even index (for positive numbers)
- neg → next odd index (for negative numbers)

Traverse the array:
- If number is positive → place at pos, move pos by 2
- If number is negative → place at neg, move neg by 2

-----------------------------------------------------

WHY THIS WORKS:

- Since number of positives == number of negatives
- We will always have space at even and odd indices

-----------------------------------------------------

EXAMPLE:

nums = [3,1,-2,-5,2,-4]

ans = [_,_,_,_,_,_]

i=0 → 3 → ans[0] = 3 → pos=2
i=1 → 1 → ans[2] = 1 → pos=4
i=2 → -2 → ans[1] = -2 → neg=3
i=3 → -5 → ans[3] = -5 → neg=5
i=4 → 2 → ans[4] = 2 → pos=6
i=5 → -4 → ans[5] = -4

Result:
[3,-2,1,-5,2,-4]

-----------------------------------------------------

EDGE CASES:

1. All positives or all negatives:
   → problem guarantees equal count, so not needed

2. Single pair:
   → works naturally

-----------------------------------------------------

TIME COMPLEXITY:
O(n)

SPACE COMPLEXITY:
O(n) (extra array used)

-----------------------------------------------------

PATTERN:

Index placement / two pointers with fixed positions
*/

class Solution {
    public int[] rearrangeArray(int[] nums) {

        int[] ans = new int[nums.length];

        int pos = 0; // even indices
        int neg = 1; // odd indices

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                ans[pos] = nums[i];
                pos += 2;
            } else {
                ans[neg] = nums[i];
                neg += 2;
            }
        }

        return ans;
    }
}