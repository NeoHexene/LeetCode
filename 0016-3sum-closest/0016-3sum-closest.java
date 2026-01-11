class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int i = 0, j = 1, k = 2;
        int mindiff = Integer.MAX_VALUE;
        int sum = 0;
        while (k < nums.length) {
            int tempsum = nums[i++] + nums[j++] + nums[k++];
            int tempdiff = Math.abs((target + target) - (tempsum + target));
            if (tempdiff < mindiff) {
                mindiff = tempdiff;
                sum = tempsum;
            } 
        }
        return sum;
    }
}