class Solution {
    public String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();
        int size = 0;
        int j = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ' ' && j == -1) {
                continue;
            } else if (c == ' ' && j != -1) {
                if (size != 0) {
                    sb.append(" ");
                }
                for (int k = i + 1; k <= j; k++) {
                    sb.append(s.charAt(k));
                }
                j = -1;
                size++;
            } else if (j == -1) {
                j = i;
            }
        }

        if (j != -1) {
            if (size != 0) {
                sb.append(" ");
            }
            for (int k = 0; k <= j; k++) {
                sb.append(s.charAt(k));
            }
            size++;
        }

        return sb.toString();
    }
}