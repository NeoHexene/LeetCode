class Solution {
    public int reverse(int x) {
        int b, sum = 0;
        int a = x;
        while(a!=0) {
            b = a%10;
            a = a/10;
            if ((sum > Integer.MAX_VALUE / 10) || (sum == Integer.MAX_VALUE / 10 && b > 7)) {
                return 0;
            }
            if ((sum < Integer.MIN_VALUE / 10) || (sum == Integer.MIN_VALUE / 10 && b < -8)) {
                return 0;
            }
            sum = sum*10 + b;
        }
        return sum;
    }
}