/*
INTUITION:

A "special substring" contains only one repeated character, such as:
"a", "aaa", "bbbb", etc.

We need the maximum length k such that some special substring of
length k occurs at least 3 times.

The important observation is that special substrings can only come
from consecutive runs of the same character.

Example:
s = "aaabbccccaa"

Runs:
"aaa" | "bb" | "cccc" | "aa"

-----------------------------------------------------

CONTRIBUTION OF A RUN:

Suppose:
- Current run length = L
- We are checking special substrings of length = k

The number of length-k substrings inside this run is:

    contribution = L - k + 1

Example:
run = "aaaa", k = 3

[aaa]a
a[aaa]

So:
contribution = 4 - 3 + 1 = 2

Overlapping occurrences ARE allowed.

If L < k, contribution <= 0, so this run contributes nothing.

-----------------------------------------------------

WHY count[26]?

Occurrences of the same special substring can come from DIFFERENT runs.

Example:
s contains:

"dddd" ... "dddd"

For k = 3:

First "dddd":
    contribution = 4 - 3 + 1 = 2

Second "dddd":
    contribution = 4 - 3 + 1 = 2

Since both are for character 'd':

    count['d'] = 2 + 2 = 4

Therefore "ddd" occurs at least 3 times.

So:
count[ch] = total number of length-k special substrings for character ch
            across ALL of its runs.

-----------------------------------------------------

HOW WE FIND EACH RUN:

i = start of the current run
j = moves until the character changes

Example:

"aaaabb"
 ↑   ↑
 i   j

The current run is [i, j), so:

    runLength = j - i

After processing it:

    i = j

This directly moves us to the beginning of the next run.

-----------------------------------------------------

WHY BINARY SEARCH?

Suppose length k is possible.

Then every smaller length is also possible.

So feasibility looks like:

k:         1  2  3  4  5
possible:  T  T  T  F  F

We need the LAST true value.

Therefore, we can binary search on the answer.

If mid is possible:
    search right → l = mid + 1

Otherwise:
    search left → h = mid - 1

After binary search:
    h = largest possible length

If h == 0, no special substring occurs 3 times → return -1.

-----------------------------------------------------

TIME COMPLEXITY:

isPossible(k):
    O(n), because we scan all runs once.

Binary Search:
    O(log n) possible lengths.

Total:
    O(n log n)

SPACE COMPLEXITY:
    O(26) = O(1)
*/

class Solution {

    // Checks whether some special substring of length k
    // occurs at least 3 times.
    private boolean isPossible(String s, int k) {

        int n = s.length();

        // count[ch] = total number of length-k special
        // substrings found for this character across all runs.
        int[] count = new int[26];

        int i = 0;

        // Process one consecutive-character run at a time.
        while (i < n) {

            // i = beginning of current run.
            int j = i;

            // Move j until the character changes.
            while (j < n && s.charAt(i) == s.charAt(j)) {
                j++;
            }

            // Current run is [i, j).
            int specialLength = j - i;

            /*
             * Number of length-k substrings inside this run:
             *
             * run = "aaaa", k = 3
             *
             * [aaa]a
             * a[aaa]
             *
             * contribution = 4 - 3 + 1 = 2
             */
            int contribution = specialLength - k + 1;

            if (contribution > 0) {

                int ch = s.charAt(i) - 'a';

                // Add this run's occurrences to occurrences
                // from previous runs of the same character.
                count[ch] += contribution;

                // We only need at least 3 occurrences.
                if (count[ch] >= 3) {
                    return true;
                }
            }

            // j is already at the start of the next run.
            i = j;
        }

        return false;
    }

    public int maximumLength(String s) {

        // Binary search for the largest possible special substring length.
        int l = 1;
        int h = s.length();

        while (l <= h) {

            int m = l + (h - l) / 2;

            if (isPossible(s, m)) {
                // m works → try a larger length.
                l = m + 1;
            } else {
                // m doesn't work → try a smaller length.
                h = m - 1;
            }
        }

        // h is the last valid length.
        // h == 0 means even length 1 did not occur 3 times.
        return h == 0 ? -1 : h;
    }
}