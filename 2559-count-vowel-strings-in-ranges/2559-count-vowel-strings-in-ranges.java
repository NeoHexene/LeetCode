class Solution {

    private boolean isVowel(char c) {
        return 'a' == c || 'e' == c || 'i' == c || 'o' == c || 'u' == c;
    }

    public int[] vowelStrings(String[] words, int[][] queries) {

        int[] prefix = new int[words.length + 1];
        prefix[0] = 0;
        int pcomp = 1;
        for (String s : words) {
            int lchar = s.length() - 1;
            if (isVowel(s.charAt(0)) && isVowel(s.charAt(lchar))) {
                prefix[pcomp] = prefix[pcomp - 1] + 1;
            } else {
                prefix[pcomp] = prefix[pcomp - 1];
            }
            pcomp++;
        }

        int res[] = new int[queries.length];
        int pres = 0;
        for (int curr[] : queries) {
            res[pres++] = prefix[curr[1] + 1] - prefix[curr[0]];
        }
        return res;
    }
}