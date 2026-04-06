/*
INTUITION:
We need the longest subarray that contains at most 2 distinct numbers.

This is a classic "sliding window" problem:
- Expand the window from the right
- Keep track of how many times each fruit type appears
- If the window has more than 2 types, shrink it from the left until it becomes valid again

The key idea is that for every position of the right pointer, we maintain the largest valid window ending at that position.

-----------------------------------------------------

BRUTE FORCE APPROACH:

Try every subarray and count distinct fruit types.

For each starting index:
- Extend the subarray to the right
- Keep a frequency map
- Stop when there are more than 2 distinct types

Time Complexity: O(n^2)  
Space Complexity: O(n)

-----------------------------------------------------

OPTIMIZED APPROACH:

Use a sliding window with a HashMap.

Why HashMap?
- It stores the frequency of each fruit type in the current window
- We can quickly know how many distinct fruit types are inside the window

Steps:
1. Expand right pointer and add fruits[right] to the map
2. If map size becomes greater than 2:
   - Shrink from the left
   - Decrease frequency of fruits[left]
   - Remove it if frequency becomes 0
3. Update the answer with the current valid window size

-----------------------------------------------------

IMPLEMENTED LOGIC:

- left and right define the current window
- map stores fruit frequencies in the window
- For every fruit at right:
    - add it to map
    - while we have more than 2 distinct fruits:
        - remove fruit from left
        - move left forward
    - update maximum window length

-----------------------------------------------------

TIME COMPLEXITY:
O(n)

Each element is added once and removed once.

SPACE COMPLEXITY:
O(1) or O(k)
- Since the map stores at most 3 types temporarily and finally at most 2 valid types
- In general, this is constant space for this problem
*/

class Solution {
    public int totalFruit(int[] fruits) {
        int left = 0, right = 0;

        // Stores frequency of fruit types inside the current window
        Map<Integer, Integer> map = new HashMap<>();

        // Maximum length of valid window found so far
        int len = 0;

        // Expand the window using the right pointer
        for (; right < fruits.length; right++) {
            // Add current fruit to the window
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            // If more than 2 fruit types exist, shrink from the left
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);

                // Remove fruit type completely if count becomes 0
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }

                // Move left pointer forward
                left += 1;
            }

            // Update maximum valid window size
            len = Math.max(len, right - left + 1);
        }

        return len;
    }
}