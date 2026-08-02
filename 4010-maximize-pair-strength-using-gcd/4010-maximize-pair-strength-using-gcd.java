class Solution {

    private long gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    
    public long maxPairStrength(int[] nums) {
        
        long res = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                
                res = Math.max(res, (long)(((long) nums[i] * nums[j]) / (gcd(nums[i], nums[j]) * gcd(nums[i], nums[j]))));
                
            }
        }

        return res;
    }
}