class Solution {

    public int longestOnes(int[] nums, int k) {
        
        int zero = 0;
        int l = 0, r = 0;
        int maxlen = 0;

        while (r < nums.length) {

            if (nums[r] == 0) {
                zero++;
            }

            while (zero > k) {
                if (nums[l] == 0) {
                    zero--;
                }
                l++;
            }

            maxlen = Math.max(maxlen, r - l + 1);

            r++;
        }

        return maxlen;
    }
}