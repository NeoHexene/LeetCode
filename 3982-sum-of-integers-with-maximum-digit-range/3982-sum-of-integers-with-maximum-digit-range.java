class Solution {

    private int getRange(int n) {
        int max = 0;
        int min = Integer.MAX_VALUE;

        while (n > 0) {
            max = Math.max(max, n % 10);
            min = Math.min(min, n % 10);
            n /= 10;
        }

        return max - min;
    }
    
    public int maxDigitRange(int[] nums) {
        int[] maxArray = new int[nums.length];
        int max = 0;
        
        for (int i = 0; i < nums.length; i++) {
            maxArray[i] = getRange(nums[i]);
            max = Math.max(maxArray[i], max);
        }

        int total = 0;

        for (int i = 0; i < nums.length; i++) {
            if (max == maxArray[i]) {
                total += nums[i];
            }
        }

        return total;
    }
}