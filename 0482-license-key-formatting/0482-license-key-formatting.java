class Solution {
    public String licenseKeyFormatting(String s, int k) {
        int temp = 0;
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0;  i--) {
            if (chars[i] != '-') {
                if (temp == k) {
                    sb.append("-");
                    temp = 0;
                }
                sb.append(Character.toUpperCase(chars[i]));
                temp++;
            } 
        }
        return sb.reverse().toString();
    }
}