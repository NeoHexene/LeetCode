class Solution {
    public int maxDiff(int num) {
        String s = String.valueOf(num);

        char maxFrom = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '9') {
                maxFrom = s.charAt(i);
                break;
            }
        }
        int max = (maxFrom == 0) ? num : replaceAll(s, maxFrom, '9');

        char minFrom = 0;
        char minTo = 0;
        if (s.charAt(0) != '1') {
            minFrom = s.charAt(0);
            minTo = '1';
        } else {
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) != '0' && s.charAt(i) != '1') {
                    minFrom = s.charAt(i);
                    minTo = '0';
                    break;
                }
            }
        }
        int min = (minFrom == 0) ? num : replaceAll(s, minFrom, minTo);

        return max - min;
    }

    private int replaceAll (String s, char from, char to) {
        StringBuffer sb = new StringBuffer(s);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == from) {
                sb.setCharAt(i, to);
            }
        }
        return Integer.parseInt(sb.toString());
    }
}