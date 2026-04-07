/*
INTUITION:
A number is a palindrome if it reads the same forward and backward.

Example:
121 → palindrome
123 → not a palindrome

So the idea is:
👉 Reverse the number and compare it with the original

If both are equal → palindrome

-----------------------------------------------------

BRUTE FORCE APPROACH:

- Convert the number to a string
- Reverse the string
- Compare with original string

Time Complexity: O(n)
Space Complexity: O(n)

-----------------------------------------------------

OPTIMIZED APPROACH (USED HERE):

- Reverse the number using math (no extra space)
- Compare reversed number with original

-----------------------------------------------------

IMPLEMENTED LOGIC:

1. Negative numbers are NOT palindrome
   (because of '-' sign)

2. Reverse the number:
   - Extract last digit using % 10
   - Add it to reversed number
   - Remove last digit using / 10

3. Compare reversed number with original

-----------------------------------------------------

TIME COMPLEXITY:
O(log10(n))  → number of digits

SPACE COMPLEXITY:
O(1)
*/

class Solution {
    public boolean isPalindrome(int x) {

        // Negative numbers cannot be palindrome
        if (x < 0)
            return false;

        // Single digit or 0 is always palindrome
        if (x == 0)
            return true;

        int temp = x; // Copy of original number
        int n = 0;    // Will store reversed number

        // Reverse the number
        while (temp != 0) {
            int units = temp % 10;  // Extract last digit
            n = (n * 10) + units;  // Build reversed number
            temp = temp / 10;      // Remove last digit
        }

        // Compare reversed number with original
        return n == x;
    }
}