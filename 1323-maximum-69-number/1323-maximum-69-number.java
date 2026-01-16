class Solution {
    public int maximum69Number (int num) {
        String s = Integer.toString(num);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '6') {
                sb.append('9');
                if (i+1 < s.length()) sb.append(s.substring(i+1, s.length()));
                break;
            }
            sb.append(s.charAt(i));
        }
        return Integer.parseInt(sb.toString());
    }
}