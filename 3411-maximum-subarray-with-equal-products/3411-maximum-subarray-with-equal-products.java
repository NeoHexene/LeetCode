class Solution {
    
    private int gcd(int a, int b) {
        return a == 0 ? b : b == 0 ? a : a > b ? gcd(a % b, b) : gcd(a, b % a);
    }

    private int lcm(int a, int b) {
        int gcd = gcd(a, b);
        return a > b ? (b / gcd) * a : (a / gcd) * b;
    }

    public int maxLength(int[] nums) {
        int maxLen = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            int currGcd = nums[i];
            int currLcm = nums[i];
            int prod = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                currGcd = gcd(currGcd, nums[j]);
                currLcm = lcm(currLcm, nums[j]);
                prod *= nums[j];
                if (prod == currGcd * currLcm) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }
        return maxLen;

    }
}