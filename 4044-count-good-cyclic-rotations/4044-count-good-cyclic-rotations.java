class Solution {

    private int[] getDoubledNums(int[] nums) {
        
        int n = nums.length;
        int[] doubled = new int[2 * n];

        for (int i = 0; i < nums.length; i++) {
            doubled[i] = nums[i];
            doubled[n + i] = nums[i];
        }

        return doubled;
    }

    private long firstHalfSum(int[] nums) {

        long sum = 0;

        for (int i = 0; i < nums.length / 2; i++) {
            sum += (long) nums[i];
        }

        return sum;
    }

    private long totalSum(int[] nums) {

        long sum = 0;
        
        for (int i = 0; i < nums.length; i++) {
            sum += (long) nums[i];
        }

        return sum;
    }
    
    public int countGoodRotations(int[] nums) {

        int[] doubled = getDoubledNums(nums);
        long firstHalfSum = firstHalfSum(nums);
        long totalSum = totalSum(nums);

        int res = firstHalfSum > totalSum - firstHalfSum ? 1 : 0;
        int half = nums.length / 2 - 1;
        
        for (int i = 1; i < nums.length; i++) {

            firstHalfSum -= doubled[i - 1];
            firstHalfSum += doubled[half + i];

            if (firstHalfSum > totalSum - firstHalfSum) {
                res++;
            }
        }

        return res;
    }
}