class Solution {
    public int numberOfSubstrings(String s) {
        int[] charCount = new int[3];
        int left = 0;
        int res = 0;
        for (int right = 0; right < s.length(); right++) {
            charCount[s.charAt(right) - 'a'] += 1;
            while (charCount[0] > 0 && charCount[1] > 0 && charCount[2] > 0) {
                res += s.length() - right;
                charCount[s.charAt(left) - 'a'] -= 1;
                left++;
            }
        }
        return res;
    }
}