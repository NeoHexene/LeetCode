class Solution {
    public int lengthOfLongestSubstring(String s) {
        // This set will store the current substring characters (no duplicates allowed)
        Set<Character> set = new HashSet<>();

        // This will store the maximum length found so far
        int maxLen = 0;

        // Left pointer of the sliding window
        int left = 0;

        // Right pointer expands the window
        for (int right = 0; right < s.length(); right++) {

            // If the character already exists in the set,
            // it means we have a duplicate in the current window
            // So we need to shrink the window from the left
            while (set.contains(s.charAt(right))) {

                // Remove the leftmost character from the set
                set.remove(s.charAt(left));

                // Move the left pointer forward
                left += 1;
            }

            // Now it's safe to add the current character (no duplicates)
            set.add(s.charAt(right));

            // Update the maximum length of substring
            // Current window size = right - left + 1
            maxLen = Math.max(maxLen, right - left + 1);
        }

        // Return the longest substring length found
        return maxLen;
    }
}