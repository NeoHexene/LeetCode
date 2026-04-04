class Solution {

    public String longestCommonPrefix(String[] strs) {

        // Edge case:
        // If array is empty → return ""
        // If only one string → that string itself is the prefix
        if (strs.length <= 1) {
            return strs.length == 0 ? "" : strs[0];
        }

        // Sort the array of strings lexicographically
        // After sorting:
        // - Strings with similar prefixes come closer
        // - The common prefix of the entire array will be
        //   the common prefix between the first and last strings
        Arrays.sort(strs);

        // First string (smallest lexicographically)
        String first = strs[0];

        // Last string (largest lexicographically)
        String last = strs[strs.length - 1];

        // If both are same → all strings are same → return directly
        if (first.equals(last)) {
            return first;
        }

        // Build the common prefix character by character
        StringBuilder sb = new StringBuilder();

        // Compare characters of first and last string
        for (int i = 0; i < Math.min(first.length(), last.length()); i++) {

            // If characters mismatch → stop
            if (first.charAt(i) != last.charAt(i)) {
                return sb.toString();
            }

            // Otherwise, append matching character
            sb.append(first.charAt(i));
        }

        // Return the prefix built so far
        return sb.toString();
    }
}