/*
INTUITION:
We are given an array and need to create a new array that is just the original array repeated twice.

Example:
nums = [1, 2, 3]
result = [1, 2, 3, 1, 2, 3]

So the task is simply copying the same array two times into a new array.

-----------------------------------------------------

BRUTE FORCE APPROACH:

- Create a new array of size 2 * n
- Use a loop:
    - First fill from 0 → n-1
    - Then again fill from n → 2n-1

Time Complexity: O(n)  
Space Complexity: O(n)

-----------------------------------------------------

OPTIMIZED APPROACH (USED HERE):

Use built-in array copy function:
System.arraycopy()

This avoids manual loops and is highly optimized internally.

-----------------------------------------------------

IMPLEMENTED LOGIC:

- Create result array of size 2 * nums.length
- Copy nums into the first half
- Copy nums again into the second half
- Return result

-----------------------------------------------------

TIME COMPLEXITY:
O(n)

SPACE COMPLEXITY:
O(n)
*/

class Solution {
    public int[] getConcatenation(int[] nums) {

        // Create result array of double size
        int[] res = new int[nums.length * 2];

        // Copy nums → first half of res
        System.arraycopy(nums, 0, res, 0, nums.length);

        // Copy nums → second half of res
        System.arraycopy(nums, 0, res, nums.length, nums.length);

        return res;
    }
}