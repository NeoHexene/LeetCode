class Solution {
    public long sumAndMultiply(int n) {
        String s = Integer.toString(n).replaceAll("0","");
        if (s.length() > 0) {
            long nLong = Long.parseLong(s);
        long temp = nLong;
        long sum = 0;
        while (temp > 0) {
            sum += temp % 10;
            temp = temp/10;
        }
        return sum * nLong;
        }
        return (long) n;
    }
}