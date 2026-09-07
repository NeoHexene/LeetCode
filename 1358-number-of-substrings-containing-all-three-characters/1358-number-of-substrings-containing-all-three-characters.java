class Solution {

    public int numberOfSubstrings(String s) {
        
        int a = -1, b = -1, c = -1, count = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == 'a') {
                a = i;
            } else if (ch == 'b') {
                b = i;
            } else {
                c = i;
            }

            if (a != -1 && b != -1 && c != -1) {
                int lastidx = a < b && a < c ? a : b < c ? b : c;
                count += (lastidx + 1);
            }
        }
        
        return count;

    }
}