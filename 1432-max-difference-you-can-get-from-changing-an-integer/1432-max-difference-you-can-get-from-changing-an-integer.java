class Solution {
    public int maxDiff(int num) {
        StringBuffer sb = new StringBuffer(String.valueOf(num));
        int min = 0;
        int max = 0;
        if (sb.charAt(0) > '1') {
            min = replaceNumbers(new StringBuffer(sb), 0, sb.charAt(0), '1');
        } else {
            int i = 1;
            while (i < sb.length() && (sb.charAt(i) == '1' || sb.charAt(i) == '0')) {
                i++;
            }
            if (i < sb.length()) {
                min = replaceNumbers(new StringBuffer(sb), i, sb.charAt(i), '0');
            } else {
                min = num;
            }
        }

        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '9') {
            i++;
        }
        if (i < sb.length()) {
            max = replaceNumbers(new StringBuffer(sb), i, sb.charAt(i), '9');
        } else {
            max = num;
        }
        
        return max - min;
    }

    private int replaceNumbers (StringBuffer s, int idx, char from, char to) {
        for (int i = idx; i < s.length(); i++) {
            if (s.charAt(i) == from) {
                s.setCharAt(i, to);
            }
        }
        return Integer.parseInt(s.toString());
    }
}