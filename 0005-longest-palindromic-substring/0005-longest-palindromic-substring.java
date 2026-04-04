class Solution {

    /*
    FIRST THOUGHT:
    If I try every substring and check whether it is a palindrome,
    that will be too slow (O(n^3)).

    So I need a smarter way.

    Observation:
    A palindrome is symmetric.
    That means every palindrome has a "center".

    A palindrome can have:
    1. one center character  -> odd length palindrome like "aba"
    2. two center characters -> even length palindrome like "abba"

    So instead of checking every substring,
    I can try every index as a center and expand outward.

    For each center:
    - expand left and right while characters match
    - when expansion stops, that gives one palindrome

    Why does this work?
    Because every palindrome must come from some center.
    So if I check all possible centers, I will not miss the answer.
    
    ------------------------------------------------------------
    
    HOW DO WE GET start AND end FROM center AND length?

    After expansion, we know:
        center = i
        length = len

    Now we need actual indices:
        start and end

    Think in terms of how far palindrome spreads:

        <--- left side --- [center] --- right side --->

    Left side length  = (len - 1) / 2
    Right side length = len / 2

    Why?

    Case 1: Odd length (len = 3, "aba")
        left  = 1
        right = 1

    Case 2: Even length (len = 4, "abba")
        left  = 1
        right = 2

    So general formula:
        left  = (len - 1) / 2
        right = len / 2

    Therefore:
        start = i - (len - 1) / 2
        end   = i + len / 2

    This single formula works for BOTH odd and even palindromes.

    ------------------------------------------------------------

    Also remember:
    After expansion stops:
        left and right go one step beyond the palindrome

    So actual palindrome length:
        len = right - left - 1
    */

    public String longestPalindrome(String s) {
        int start = 0, end = 0;

        // Try every index as a possible center
        for (int i = 0; i < s.length(); i++) {

            // Odd-length palindrome center at i
            int len1 = expandAroundCenter(s, i, i);

            // Even-length palindrome center between i and i+1
            int len2 = expandAroundCenter(s, i, i + 1);

            // Take the longer one
            int len = Math.max(len1, len2);

            // If this palindrome is longer than the previous best,
            // update start and end positions
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        // Return the longest palindrome substring found
        return s.substring(start, end + 1);
    }

    /*
    This function expands around the given left and right pointers
    and returns the length of the palindrome.

    Example:
    - "aba" with left = 1, right = 1
    - "abba" with left = 1, right = 2
    */
    private int expandAroundCenter(String s, int left, int right) {
        while (
            left >= 0 &&
            right < s.length() &&
            s.charAt(left) == s.charAt(right)
        ) {
            left--;
            right++;
        }

        // After the loop ends, left/right are one step outside the palindrome
        return right - left - 1;
    }
}