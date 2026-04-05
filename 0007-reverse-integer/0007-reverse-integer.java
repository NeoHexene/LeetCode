class Solution {
    public int reverse(int x) {
        int n = Math.abs(x);
        long ans = 0;
        while(n > 0) {
            System.out.println("Ans: "+ans+" n: "+n);
            int rem = n % 10;
            ans *= 10;
            ans += rem;
            n = n / 10;
        }

        if (ans > Integer.MAX_VALUE) {
            return 0;
        } else {
            int res = (int) ans * (x < 0 ? -1 : 1);
            return res;
        }
    }
}