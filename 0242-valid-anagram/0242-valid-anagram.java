class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] st = new int[256];
        int[] ts = new int[256];

        for (int i = 0; i < s.length(); i++) {
            st[s.charAt(i)]++;
            ts[t.charAt(i)]++;
        }

        for (int i = 0; i < 256; i++) {
            if (st[i] != ts[i]) {
                return false;
            }
        }

        return true;
    }
}