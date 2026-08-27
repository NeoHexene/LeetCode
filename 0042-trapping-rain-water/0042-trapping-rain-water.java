class Solution {
    
    public int trap(int[] height) {

        /*
        Brute force: 
        int n = height.length;
        
        int[] leftmax = new int[n];
        leftmax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftmax[i] = Math.max(leftmax[i - 1], height[i]);
        }

        int[] rightmax = new int[n];
        rightmax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightmax[i] = Math.max(rightmax[i + 1], height[i]);
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            total += (Math.min(leftmax[i], rightmax[i]) - height[i]);
        }

        return total;
        */

        // Optimal:

        int l = 0, r = height.length - 1, lmax = 0, rmax = 0, total = 0;

        while (l < r) {
            
            lmax = Math.max(lmax, height[l]);
            rmax = Math.max(rmax, height[r]);

            if (lmax < rmax) {
                total += (lmax - height[l]);
                l++;
            } else {
                total += (rmax - height[r]);
                r--;
            }
        }

        return total;
    }
}