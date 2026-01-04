class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int i = 0;
        int j = 1;
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        char[] sarr = s.toCharArray();
        map.put(sarr[i], 0);
        while (j < n) {
            if (map.containsKey(sarr[j])) {
                max = Math.max(max, map.size());
                int idx = map.get(sarr[j]);
                while (i <= idx) {
                    map.remove(sarr[i]);
                    i++;
                }
                map.put(sarr[i], i);
                if (i == j) {
                    j++;
                }
            } else {
                map.put(sarr[j], j);
                j++;
            }
        }
        max = Math.max(max, map.size());
        return max;
    }
}