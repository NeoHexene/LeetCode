class Solution {
    public int maxProduct(int[] nums) {
        
        int max1 = 0;
        int max2 = 0;
        
        for (int n : nums) {
            if (max1 < n) {
                max2 = max1;
                max1 = n;
            } else {
                max2 = Math.max(max2, n);
            }
        }

        return (max1 - 1) * (max2 - 1);
    }
}