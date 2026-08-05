class Solution {

    private int number(String s, int idx, long num, int sign) {
        
        if (idx >= s.length() || !Character.isDigit(s.charAt(idx))) {
            return (int) num * sign;
        }

        num = num * 10 + (s.charAt(idx) - '0');

        if (num * sign <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        if (num * sign >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        return number(s, idx + 1, num, sign);
    }

    public int myAtoi(String s) {

        int idx = 0;

        while (idx < s.length() && s.charAt(idx) == ' ') {
            idx++;
        }

        int sign = 1;
        if (idx < s.length() && (s.charAt(idx) == '+' || s.charAt(idx) == '-')) {
            if (s.charAt(idx) == '-') {
                sign = -1;
            }
            idx++;
        }

        return number(s, idx, 0l, sign);
    }
}