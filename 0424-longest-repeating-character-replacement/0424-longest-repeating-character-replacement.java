class Solution {

    public int characterReplacement(String s, int k) {

        int l = 0, r = 0, maxfreq = 0, maxlen = 0;
        int[] count = new int[26];
        
        while (r < s.length()) {
            
            count[s.charAt(r) - 'A']++;

            if (maxfreq < count[s.charAt(r) - 'A']) {
                maxfreq = count[s.charAt(r) - 'A'];
            }

            int currlen = r - l + 1;

            if (currlen - maxfreq <= k) {
                maxlen = Math.max(maxlen, currlen);
            } else {
                count[s.charAt(l) - 'A']--;
                l++;
            }

            r++;
        }

        return maxlen;
    }
}