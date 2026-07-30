class Solution {
    public int minimumPushes(String word) {
        
        int n = word.length();
        
        if (n <= 8) {
            return n;
        }
        
        int mul = 1;
        int count = 0;

        while (n > 8) {
            count += (8 * mul);
            mul++;
            n -= 8;
        }

        count += (n * mul);

        return count;
        
    }
}