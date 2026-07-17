class Solution {

    private int getDifference(int[] freq) {
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                min = Math.min(min, freq[i]);
                max = Math.max(max, freq[i]);
            }
        }

        return max - min;
    }

    public int beautySum(String s) {

        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            int freq[] = new int[26];
            freq[s.charAt(i) - 'a']++;
            for (int j = i + 1; j < s.length(); j++) {
                freq[s.charAt(j) - 'a']++;
                res += getDifference(freq);
            }
        }

        return res;

    }
}