/*
INTUITION:

For each index i, we need:
    sum of distances to all other indices j such that nums[i] == nums[j]

Brute force would compare every pair → O(n²)

Key observation:
    Equal values are independent of each other

So:
- Group indices by value
- Solve each group separately

-----------------------------------------------------

CORE IDEA (VERY IMPORTANT):

Suppose for a value x, its indices are:
list = [i1, i2, i3, ..., ik]

For a position list[i], we want:
sum of distances to all other indices in the same list

Split into:
1. Left side (indices before i)
2. Right side (indices after i)

-----------------------------------------------------

FORMULA DERIVATION:

For current index = list[i]

LEFT side:
distance = (list[i] - list[0]) + (list[i] - list[1]) + ... (i times)

This simplifies to:
    list[i] * i - sum(left elements)

RIGHT side:
distance = (list[i+1] - list[i]) + (list[i+2] - list[i]) + ...

This simplifies to:
    sum(right elements) - list[i] * (count of right elements)

-----------------------------------------------------

WHY THIS IS FAST:

Instead of recomputing sums repeatedly:
- Maintain prefix sum (leftSum)
- Use total sum to compute rightSum

-----------------------------------------------------

APPROACH:

1. Build map:
   value → list of indices

2. For each list:
   - compute total sum of indices
   - iterate and maintain prefix sum (leftSum)
   - compute:
        left = list[i] * i - leftSum
        right = rightSum - list[i] * (m - i - 1)

3. Store result at original index

-----------------------------------------------------

TIME COMPLEXITY:

O(n)

- Building map → O(n)
- Processing each index once → O(n)

-----------------------------------------------------

SPACE COMPLEXITY:

O(n)

- Map stores all indices
- Result array

-----------------------------------------------------

KEY PATTERN:

    "Group + Prefix Sum Optimization"

Whenever you see:
- sum of distances
- same values grouping

Think:
    prefix sum trick instead of brute force
*/

class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;

        long[] res = new long[n];

        // Step 1: Group indices by value
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        
        // Step 2: Process each group independently
        for (List<Integer> list : map.values()) {

            // Total sum of indices in this group
            long sum = 0;
            for (int x : list) {
                sum += x;
            }

            long leftSum = 0; // prefix sum of indices
            int m = list.size();

            for (int i = 0; i < m; i++) {

                int currIndex = list.get(i);

                // Sum of indices to the right
                long rightSum = sum - leftSum - currIndex;

                /*
                 * LEFT CONTRIBUTION:
                 * distance to all elements before i
                 * = currIndex * i - leftSum
                 */
                long left = (long) currIndex * i - leftSum;

                /*
                 * RIGHT CONTRIBUTION:
                 * distance to all elements after i
                 * = rightSum - currIndex * (m - i - 1)
                 */
                long right = rightSum - (long) currIndex * (m - i - 1);

                // Store total distance
                res[currIndex] = left + right;

                // Update prefix sum
                leftSum += currIndex;
            }
        }

        return res;
    }
}