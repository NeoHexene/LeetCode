/*
INTUITION:
Every number in the array appears twice except one.
We need to find that single number.

Key observation:
XOR (^) has some very useful properties:
1. a ^ a = 0  (same numbers cancel out)
2. a ^ 0 = a
3. XOR is commutative and associative

So if we XOR all elements:
- All duplicate numbers will cancel each other out
- Only the unique number will remain

-----------------------------------------------------

BRUTE FORCE APPROACH:

For each element:
- Count how many times it appears in the array
- Return the element with frequency = 1

Time Complexity: O(n^2)  
Space Complexity: O(1)

-----------------------------------------------------

BETTER APPROACH:

Use a HashMap to count frequencies.

- Traverse array and store counts
- Traverse map to find element with count = 1

Time Complexity: O(n)  
Space Complexity: O(n)

-----------------------------------------------------

OPTIMIZED APPROACH (USED HERE):

Use XOR to eliminate duplicates in one pass.

Steps:
- Initialize result = 0
- XOR all numbers
- Duplicates cancel out → only single number remains

-----------------------------------------------------

IMPLEMENTED LOGIC:

- Start with res = 0
- For each number in nums:
    res = res ^ number
- Final res will be the unique number

-----------------------------------------------------

TIME COMPLEXITY:
O(n)

SPACE COMPLEXITY:
O(1)
*/

class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;

        // XOR all elements
        for (int n : nums) {
            res ^= n; // duplicates cancel out
        }

        // Remaining value is the single number
        return res;
    }
}