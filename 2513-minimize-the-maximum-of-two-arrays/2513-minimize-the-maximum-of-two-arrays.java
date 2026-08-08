class Solution {
    public int minimizeSet(int divisor1, int divisor2, int uniqueCnt1, int uniqueCnt2) {
        
        long low = 1l;
        long high = 2l * (uniqueCnt1 + uniqueCnt2);

        while (low <= high) {
            
            long mid = low + (high - low) / 2;

            if (checkFeasibility(mid, divisor1, divisor2, uniqueCnt1, uniqueCnt2)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return (int) low;
    }

    private boolean checkFeasibility(long n, int div1, int div2, int uc1, int uc2) {
        
        long grp1 = n - (n / div1);
        long grp2 = n - (n / div2);
        long common = n + (n / lcm(div1, div2)) - (n / div1) - (n / div2);

        return (grp1 >= uc1) && (grp2 >= uc2) && (grp1 + grp2 - common >= uc1 + uc2);
    }

    private long lcm(long a, long b) {
        
        return a / gcd(a, b) * b;
    }

    private long gcd(long a, long b) {

        return b == 0 ? a : gcd(b, a % b);
    }
}