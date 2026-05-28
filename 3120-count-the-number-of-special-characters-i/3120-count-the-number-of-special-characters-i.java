class Solution {
    public int numberOfSpecialChars(String word) {
        boolean[] low = new boolean[26];
        boolean[] upp = new boolean[26];
        boolean[] checked = new boolean[26];

        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                if (low[word.charAt(i) - 'A'] && !checked[word.charAt(i) - 'A']) {
                    count += 1;
                    checked[word.charAt(i) - 'A'] = true;
                }
                upp[word.charAt(i) - 'A'] = true;
            } else {
                if (upp[word.charAt(i) - 'a'] && !checked[word.charAt(i) - 'a']) {
                    count += 1;
                    checked[word.charAt(i) - 'a'] = true;
                }
                low[word.charAt(i) - 'a'] = true;
            }
        }

        return count;
    }
}