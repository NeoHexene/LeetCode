class Solution {
    public int val(char c) {
        if (c == 'I') {
            return 1;
        }
        else if (c == 'V') {
            return 5;
        }
        else if (c == 'X') {
            return 10;
        }
        else if (c == 'L') {
            return 50;
        }
        else if (c == 'C') {
            return 100;
        }
        else if (c == 'D') {
            return 500;
        }
        else {
            return 1000;
        }
    }
    
    public int romanToInt(String s) {
        int sum = 0;
        char prev = s.charAt(0);
        sum = sum + val(prev);
        for (int i = 1; i<s.length(); i++) {
            if (val(prev) >= val(s.charAt(i))) {
                sum = sum + val(s.charAt(i));
            }
            else { // val(prev) < val(s.charAt(i))
                sum = sum + (val(s.charAt(i)) - (2 * val(prev)));
            }
            prev = s.charAt(i);
        }
        return sum;
    }
}