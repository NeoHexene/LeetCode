class Solution {
    public String trimTrailingVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = s.length() - 1; i>= 0; i--) {
            char c = sb.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                sb.deleteCharAt(i);
            else 
                break;
        }
        return sb.toString();
    }
}