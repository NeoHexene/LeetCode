class Solution {
    public long removeZeros(long n) {
        String s = Long.toString(n).replaceAll("0","");
        if (s.length() > 0) {
            return Long.parseLong(s);
        }
        return n;
    }
}