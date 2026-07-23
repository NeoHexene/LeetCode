class Solution {

    private String helper(String s, int i, int j) {
        StringBuilder sb = new StringBuilder();
        if (j > 0) {
            sb.append(" ");
        }
        for (int k = i; k >= j; k--) {
            sb.append(s.charAt(k));
        }

        return sb.toString();
    }

    public String reverseWords(String s) {
        int i = 0, j = 0, n = s.length();
        StringBuilder sb = new StringBuilder();

        while (i < n) {
            if (s.charAt(i) == ' ') {
                sb.append(helper(s, i - 1, j));
                j = i + 1;
            }
            i++;
        }

        if (j < i) {
            sb.append(helper(s, i - 1, j));
        }

        return sb.toString();

    }
}