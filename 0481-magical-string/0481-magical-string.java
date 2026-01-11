class Solution {
    public int magicalString(int n) {
        StringBuilder sb = new StringBuilder("122");
        char r = '1';
        int w = 2;
        while (sb.length() < n) {
            String repeat = String.valueOf(r).repeat(sb.charAt(w) - '0');
            sb.append(repeat);
            w++;
            if (r == '1') r = '2';
            else r = '1';
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (sb.charAt(i) == '1') count += 1;
        }
        return count;
    }
}