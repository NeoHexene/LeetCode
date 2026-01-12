class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0, maxFreq = 0, currLen = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            currLen = j - i + 1;
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            maxFreq = Collections.max(map.values());

            while (currLen - maxFreq > k) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                maxFreq = Collections.max(map.values());
                i++;
                currLen = j - i + 1;
            }
            
            maxLen = Math.max(currLen, maxLen);
        }
        return maxLen;
    }
}