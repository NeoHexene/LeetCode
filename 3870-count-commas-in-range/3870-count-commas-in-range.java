class Solution {
    //     999,999 -     999 ->    999000 numbers with 1 comma
    // 999,999,999 - 999,999 -> 999000000 numbers with 2 comma
    
    public int countCommas(int n) {
        if (n < 1000) {
            return 0;
        }
        
        int total = 0;
        int start = 1000;
        int commas = 1;

        while (start <= n) {
            int end = Math.min(n, start * 1000 - 1);
            int count = end - start + 1;
            total += count * commas;

            start *= 1000;
            commas++;
        }

        return total;
    }
}