class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lc = new int[26];
        int[] uc = new int[26];

        for (int i = 0; i < 26; i++) {
            lc[i] = -1;
            uc[i] = -1;
        }


        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isLowerCase(c)) {
                lc[c - 'a'] = i;
            } else if (uc[c - 'A'] == -1) {
                uc[c - 'A'] = i;
            }
        }
        
        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (lc[i] != -1 && uc[i] != -1 && lc[i] < uc[i]) {
                count += 1;
            }
        }

        return count;
    }
}