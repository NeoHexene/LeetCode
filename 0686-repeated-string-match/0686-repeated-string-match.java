class Solution {
    public int repeatedStringMatch(String a, String b) {
        if (a.contains(b)) {
            return 1;
        }
        String repeatA = a;
        int count = 1;
        if (repeatA.contains(b)) {
            return count;
        }
        while (repeatA.length() < b.length()) {
            repeatA += a;
            count += 1;
            if (repeatA.contains(b)) {
                return count;    
            }
        }
        repeatA += a;
        count += 1;
        if (repeatA.contains(b)) {
            return count;
        }
        return -1;
    }
}