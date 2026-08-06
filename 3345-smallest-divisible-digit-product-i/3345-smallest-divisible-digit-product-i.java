class Solution {

    private boolean check(int n, int t) {
        
        int prod = 1;

        while (n > 0) {
            prod *= (n % 10);
            n /= 10;

            if (prod == 0) {
                break;
            }
        }

        return prod % t == 0;
    }

    public int smallestNumber(int n, int t) {
        
        while (!check(n, t)) {
            n++;
        }

        return n;
    }
}