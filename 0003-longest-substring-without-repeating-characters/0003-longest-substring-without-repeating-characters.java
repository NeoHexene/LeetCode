class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) {
            return s.length();
        }
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < s.length(); right ++) {
            char c = s.charAt(right);
            if (map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1;
            }
            maxLen = Math.max(right - left + 1, maxLen);
            map.put(c, right);
        }
        return maxLen;
    }
}