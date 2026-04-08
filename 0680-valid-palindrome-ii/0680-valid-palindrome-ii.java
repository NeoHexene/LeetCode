/*
INTUITION:
We are allowed to delete at most ONE character to make the string a palindrome.

Using two pointers:
- Compare characters from both ends
- If they match → move inward
- If they don’t match → we have ONE chance:
    → either skip left character OR skip right character

If either option forms a palindrome → return true

-----------------------------------------------------

BRUTE FORCE APPROACH:

- Try removing each character one by one
- For each removal, check if the string is a palindrome

Time Complexity: O(n^2)
Space Complexity: O(1)

-----------------------------------------------------

OPTIMIZED APPROACH (USED HERE):

Two pointers + one allowed deletion.

Key idea:
    At first mismatch, try BOTH possibilities:
    1. Skip left character
    2. Skip right character

-----------------------------------------------------

IMPLEMENTED LOGIC:

1. Start with two pointers (left, right)
2. Move inward while characters match
3. On mismatch:
   - Check if substring (left+1 → right) is palindrome
   - OR substring (left → right-1) is palindrome
4. If either works → valid

-----------------------------------------------------

TIME COMPLEXITY:
O(n)

SPACE COMPLEXITY:
O(1)
*/

class Solution {
    public boolean validPalindrome(String s) {

        int left = 0, right = s.length() - 1;

        // Traverse from both ends
        while (left < right) {

            // If mismatch found
            if (s.charAt(left) != s.charAt(right)) {

                /*
                 * We have one chance to delete a character:
                 * Option 1 → skip left character
                 * Option 2 → skip right character
                 */
                return isPalindrome(s, left + 1, right) ||
                       isPalindrome(s, left, right - 1);
            }

            // Move both pointers inward
            left++;
            right--;
        }

        // If no mismatch or resolved → valid
        return true;
    }

    private boolean isPalindrome(String s, int start, int end) {

        // Standard palindrome check using two pointers
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}