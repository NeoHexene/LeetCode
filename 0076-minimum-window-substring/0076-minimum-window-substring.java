class Solution {
    public String minWindow(String s, String t) {
        
        int[] map = new int[256];

        for (int i = 0; i < t.length(); i++) {
            map[t.charAt(i)]++;
        }

        int l = 0, r = 0, minlen = s.length() + 1, startIdx = -1, count = 0;

        while (r < s.length()) {

            if (map[s.charAt(r)] > 0) {
                count++;
            }

            map[s.charAt(r)]--;

            while (count >= t.length()) {
                
                if ((r - l + 1) < minlen) {
                    startIdx = l;
                    minlen = r - l + 1;
                }

                map[s.charAt(l)]++;

                if (map[s.charAt(l)] > 0) {
                    count--;
                }

                l++;
            }

            r++;
        }

        return startIdx == -1 ? "" : s.substring(startIdx, startIdx + minlen);
    }
}