/*
INTUITION:
For every distinct number, we know how many times it appears.

We need to split that frequency into groups such that:
- each group has size x or x + 1
- all groups are valid
- total number of groups is minimum

To minimize the number of groups, we try the largest possible base size first.
If a base size works for all frequencies, we return that answer immediately.

-----------------------------------------------------

WHY DO WE TRY SIZE FROM MAX TO MIN?

Let minFreq be the smallest frequency among all numbers.

- We cannot choose a base size bigger than minFreq
- If we choose a larger base size, we make fewer groups
- So we start from minFreq and move downward

This guarantees the first valid answer is optimal.

-----------------------------------------------------

HOW DO WE CHECK ONE FREQUENCY?

Suppose a number appears val times and our base size is size.
Then each group can be either:
- size
- size + 1

We first try to make as many groups of size + 1 as possible.
Then we check whether the remaining elements can still fit into valid groups.

If yes, that frequency is feasible.
If no, the chosen size is invalid.

-----------------------------------------------------

TIME COMPLEXITY:
Let m = number of distinct values, and n = total length of nums.

- Counting frequency: O(n)
- Trying sizes: up to O(minFreq)
- Checking all frequencies for each size: O(m)

Worst case: O(minFreq * m)
Space: O(m)
*/

class Solution {
    public int minGroupsForValidAssignment(int[] nums) {
        // Step 1: Count frequency of each number
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        // Step 2: Find the smallest frequency
        // Base size cannot be larger than this
        int min = nums.length;
        for (int val : map.values()) {
            min = Math.min(min, val);
        }

        // Step 3: Try all possible base sizes from largest to smallest
        // Larger base size means fewer groups
        for (int size = min; size > 0; size--) {
            int groups = groupify(map, size);

            // If this size works for all numbers, return the answer
            if (groups > 0) {
                return groups;
            }
        }

        // Fallback: every element becomes its own group
        return nums.length;
    }

    private int groupify(Map<Integer, Integer> map, int size) {
        int groups = 0;

        // We will try to form groups of size 'size' or 'size + 1'
        int next = size + 1;

        for (int val : map.values()) {
            // Try to make as many bigger groups as possible first
            int numGroups = val / next;
            int remaining = val % next;

            if (remaining == 0) {
                // Perfectly divisible into groups of size + 1
                groups += numGroups;
            } else if (numGroups >= size - remaining) {
                /*
                 * We have some leftover elements.
                 * This condition checks if we can redistribute them
                 * by slightly adjusting the group counts.
                 *
                 * If this is true, this frequency can still be split
                 * into groups of size 'size' or 'size + 1'.
                 */
                groups += numGroups + 1;
            } else {
                // This base size does not work for this frequency
                return 0;
            }
        }

        return groups;
    }
}