class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {

        int comp[] = new int[words.length];
        int pcomp = 0;
        for (String s : words) {
            int lchar = s.length() - 1;
            if (('a' == s.charAt(0) || 'e' == s.charAt(0) || 'i' == s.charAt(0) || 'o' == s.charAt(0) || 'u' == s.charAt(0)) && ('a' == s.charAt(lchar) || 'e' == s.charAt(lchar) || 'i' == s.charAt(lchar) || 'o' == s.charAt(lchar) || 'u' == s.charAt(lchar))) {
                comp[pcomp++] = 1;
            } else {
                comp[pcomp++] = 0;
            }
        } 

        int[] prefix = new int[comp.length + 1];
        prefix[0] = 0;
        for (int i = 0; i < comp.length; i++) {
            prefix[i + 1] = prefix[i] + comp[i];
        }

        int res[] = new int[queries.length];
        int pres = 0;
        for (int curr[] : queries) {
            res[pres++] = prefix[curr[1] + 1] - prefix[curr[0]];
        }
        return res;
    }
}