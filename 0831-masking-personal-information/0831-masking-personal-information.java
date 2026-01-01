class Solution {
    public String maskPII(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.contains("@")) {
            int idx = s.indexOf("@");
            sb.append(Character.toLowerCase(s.charAt(0)));
            sb.append("*****");
            sb.append(Character.toLowerCase(s.charAt(idx-1)));
            sb.append(s.substring(idx, s.length()).toLowerCase());
            return sb.toString();
        } else {
            char[] sarr = s.toCharArray();
            boolean four = false;
            for (int i = sarr.length - 1; i >= 0; i--) {
                if (sarr[i] == '+' || sarr[i] == '-' || sarr[i] == '(' || sarr[i] == ')' || sarr[i] == ' ') {
                    continue;
                }
                if(sb.length() > 0 && sb.length() % 4 == 0) {
                    sb.append('-');
                }
                if (sb.length() <= 4) {
                    sb.append(sarr[i]);
                } else {
                    sb.append('*');
                }
            }
            if (sb.length() > 12) {
                sb.append('+');
            }
            return sb.reverse().toString();
        }
    }
}