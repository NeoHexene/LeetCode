/*
INTUITION:
We want to rearrange the string so that no two adjacent characters are the same.

A very important observation is:
- If any character appears more than (n + 1) / 2 times,
  then it is impossible to rearrange the string.

Why?
Because that character would need to be placed too many times, and at some point
two of them would be forced to sit next to each other.

To build the answer, we always want to pick the character with the highest remaining frequency,
but we must avoid placing the same character twice in a row.
That is why we use a max heap (priority queue).

-----------------------------------------------------

BRUTE FORCE APPROACH:

Try all permutations of the string and check if any valid arrangement exists.

Time Complexity: O(n!)
Space Complexity: O(n)

This is obviously too slow.

-----------------------------------------------------

OPTIMIZED APPROACH:

1. Count frequency of each character.
2. Check feasibility:
   - if any frequency > (n + 1) / 2, return ""
3. Put all characters into a max heap based on frequency.
4. Repeatedly:
   - take the most frequent character
   - if it is the same as the last character in the result,
     take the second most frequent character instead
   - append the chosen character
   - decrease its count and push it back if still remaining

This ensures we always place the most useful character while avoiding adjacent duplicates.

-----------------------------------------------------

TIME COMPLEXITY:
O(n log k)
where k = number of distinct characters

SPACE COMPLEXITY:
O(k)
*/

class Solution {
    public String reorganizeString(String s) {
        // Count frequency of every character
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // Early impossible check:
            // If any character appears too many times, valid arrangement is impossible
            if (map.get(ch) > (s.length() + 1) / 2) {
                return "";
            }
        }

        // Max heap:
        // Each element is [frequency, character]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for (Character key : map.keySet()) {
            pq.offer(new int[]{map.get(key), key});
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            // Pick the most frequent character
            int[] temp1 = pq.poll();

            // If this character is same as the last appended one,
            // we need to choose the second most frequent character instead
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == (char) temp1[1]) {
                int[] temp2 = pq.poll();

                // Append the second best character
                sb.append((char) temp2[1]);

                // Decrease its frequency and push it back if still available
                if (temp2[0] - 1 > 0) {
                    pq.offer(new int[]{temp2[0] - 1, temp2[1]});
                }

                // Put the first character back since we did not use it
                pq.offer(temp1);
            } else {
                // Safe to append the most frequent character
                sb.append((char) temp1[1]);

                // Decrease its frequency and push it back if still available
                if (temp1[0] - 1 > 0) {
                    pq.offer(new int[]{temp1[0] - 1, temp1[1]});
                }
            }
        }

        return sb.toString();
    }
}