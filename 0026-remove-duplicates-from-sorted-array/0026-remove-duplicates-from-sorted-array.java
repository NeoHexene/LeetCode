/*
INTUITION:

The array is sorted, which means duplicates appear next to each other.

Goal:
- Remove duplicates in-place
- Keep only one occurrence of each number
- Return the length of the unique portion

Key idea:
Use two pointers:
- j → scans the array (read pointer)
- i → builds the result (write pointer)

-----------------------------------------------------

APPROACH:

1. First element is always unique → start i = 1
2. Iterate j from 1 to n-1:
   - If nums[j] is different from last unique element (nums[i-1]):
        → it is a new unique value
        → place it at nums[i]
        → increment i
3. At the end, first i elements are unique

-----------------------------------------------------

WHY nums[i - 1]?

nums[i - 1] always stores the last unique element inserted.
So we compare current element with last unique element.

-----------------------------------------------------

EXAMPLE:

nums = [1,1,2,2,3]

i = 1

j = 1 → nums[1] == nums[0] → skip
j = 2 → nums[2] != nums[0] → nums[1] = 2, i = 2
j = 3 → nums[3] == nums[1] → skip
j = 4 → nums[4] != nums[1] → nums[2] = 3, i = 3

Final array (first 3 elements):
[1,2,3]

-----------------------------------------------------

TIME COMPLEXITY:
O(n)

SPACE COMPLEXITY:
O(1) (in-place)

-----------------------------------------------------

PATTERN:

Two pointers (read + write) on a sorted array
*/

class Solution {
    public int removeDuplicates(int[] nums) {

        // Edge case: empty array
        if (nums.length == 0) {
            return 0;
        }

        // i points to next position for unique element
        int i = 1;

        // j scans through the array
        for (int j = 1; j < nums.length; j++) {

            // If current element is different from last unique
            if (nums[j] != nums[i - 1]) {

                // Place it at index i
                nums[i] = nums[j];

                // Move write pointer
                i++;
            }
        }

        // i is the count of unique elements
        return i;
    }
}