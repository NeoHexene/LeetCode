class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String res = "";

        for (String s : words) {
            int total = 0;
            for (int i = 0; i < s.length(); i++) {
                total += weights[s.charAt(i) - 'a'];
            }
            res += (char) ('z' - (total % 26));
        }

        return res;
    }
}