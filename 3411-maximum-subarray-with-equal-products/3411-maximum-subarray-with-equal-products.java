/*
INTUITION:

For every subarray, we want to check whether:

    product of all elements == gcd of all elements * lcm of all elements

The condition is not something we can decide from a single element.
So we try every subarray and maintain these three values incrementally.

The key optimization in this code is:
- do NOT recompute gcd/lcm/product from scratch for every subarray
- instead, fix the left boundary and extend the right boundary one step at a time

That way:
- gcd can be updated using the previous gcd
- lcm can be updated using the previous lcm
- product can be updated by multiplication

-----------------------------------------------------

LOGIC BUILDING:

Suppose we fix a starting index i.

Then for every ending index j >= i:
- current gcd = gcd of nums[i...j]
- current lcm = lcm of nums[i...j]
- current product = product of nums[i...j]

We extend the subarray one element at a time:
- include nums[j]
- update gcd, lcm, product
- check whether the equality holds

If yes:
- update answer with subarray length (j - i + 1)

-----------------------------------------------------

WHY THIS WORKS:

The condition depends only on the values inside the subarray.
So for each subarray, checking:
    product == gcd * lcm
is enough.

Since we are scanning all subarrays, we will not miss any valid answer.

-----------------------------------------------------

APPROACHES:

1. Full brute force
   - For every subarray, recompute gcd, lcm, and product from scratch.
   - Time: O(n^3 * log V)
   - Space: O(1)

2. Your current approach
   - Fix left boundary
   - Expand right boundary
   - Maintain gcd/lcm/product incrementally
   - Time: O(n^2 * log V)
   - Space: O(1)

3. Pruned brute force
   - Same as above, but break early when values overflow or become impossible
   - Average may improve, but worst case is still O(n^2 * log V)

There is no widely-used standard subquadratic solution for this exact check in general form.

-----------------------------------------------------

IMPORTANT IMPLEMENTATION NOTE:

Use `long` instead of `int` for:
- product
- gcd * lcm comparison

Because `int` can overflow very easily.

-----------------------------------------------------

TIME COMPLEXITY:

Outer loop runs O(n)
Inner loop runs O(n)
Each gcd/lcm update takes O(log V)

So total:
    O(n^2 * log V)

Where V is the value size of numbers.

SPACE COMPLEXITY:
    O(1)
*/

class Solution {

    // Euclid's algorithm for gcd
    private int gcd(int a, int b) {
        return a == 0 ? b : b == 0 ? a : a > b ? gcd(a % b, b) : gcd(a, b % a);
    }

    // lcm(a, b) = (a / gcd(a, b)) * b
    private int lcm(int a, int b) {
        int gcd = gcd(a, b);
        return a > b ? (b / gcd) * a : (a / gcd) * b;
    }

    public int maxLength(int[] nums) {
        int maxLen = 1;

        // Fix the starting point of the subarray
        for (int i = 0; i < nums.length - 1; i++) {
            int currGcd = nums[i];
            int currLcm = nums[i];
            int prod = nums[i];

            // Extend the subarray to the right
            for (int j = i + 1; j < nums.length; j++) {
                currGcd = gcd(currGcd, nums[j]);
                currLcm = lcm(currLcm, nums[j]);

                // Update product incrementally
                prod *= nums[j];

                // Check the required condition
                if (prod == currGcd * currLcm) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }
}