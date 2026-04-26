/*
INTUITION:

We want the maximum sum of any contiguous subarray.

Brute force:
- Try all subarrays → O(n^2) or O(n^3)

Optimal:
    Kadane’s Algorithm

-----------------------------------------------------

CORE IDEA:

At every index, decide:
    Should I extend the previous subarray OR start fresh?

So:
currmax = max(current element, previous sum + current element)

-----------------------------------------------------

WHY THIS WORKS:

If the previous sum becomes negative:
→ it will only decrease the total
→ better to start a new subarray

-----------------------------------------------------

APPROACH:

1. Maintain:
   - currmax → max subarray ending at current index
   - res → overall maximum

2. For each element:
   - decide whether to start new or extend
   - update result

-----------------------------------------------------

EXAMPLE:

nums = [-2,1,-3,4,-1,2,1,-5,4]

Step-by-step:
currmax evolves as:
-2 → 1 → -2 → 4 → 3 → 5 → 6 → 1 → 5

res = 6

-----------------------------------------------------

EDGE CASES:

1. All negative numbers:
   → works because res starts from INT_MIN

2. Single element:
   → handled automatically

-----------------------------------------------------

TIME COMPLEXITY:
O(n)

SPACE COMPLEXITY:
O(1)

-----------------------------------------------------

PATTERN:

Dynamic Programming (Kadane)
- "Best ending here"
*/

class Solution {
public:
    int maxSubArray(vector<int>& nums) {

        int currmax = 0;       // max sum ending at current index
        int res = INT_MIN;     // global max

        for (auto n : nums) {

            // Either start new subarray or extend previous one
            currmax = max(n, currmax + n);

            // Update global maximum
            res = max(res, currmax);
        }

        return res;
    }
};