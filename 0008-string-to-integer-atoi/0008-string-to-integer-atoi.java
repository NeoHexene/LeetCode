class Solution {
    public int myAtoi(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int i = 0;
        long res = 0l;
        int mul = 1;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        if (i < s.length() && s.charAt(i) == '-') {
            mul = -1;
            i++;
        } else if (i < s.length() && s.charAt(i) == '+') {
            i++;
        }
        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            res = res * 10 + (long) (s.charAt(i) - '0');
            if (res > Integer.MAX_VALUE) {
                if (mul == -1) {
                    return Integer.MIN_VALUE;
                }
                return Integer.MAX_VALUE;
            }
            i++;
        }

        return (int) res * mul;
    }
}