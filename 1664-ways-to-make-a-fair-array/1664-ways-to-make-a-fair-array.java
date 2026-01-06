class Solution {
    public int waysToMakeFair(int[] nums) {
        int totalEven = 0, totalOdd = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                totalEven += nums[i];
            } else {
                totalOdd += nums[i];
            }
        }
        int leftEven= 0, leftOdd = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                totalEven -= nums[i];
            } else {
                totalOdd -= nums[i];
            }
            if (totalEven + leftOdd == totalOdd + leftEven) {
                count += 1;
            }
            if (i % 2 == 0) {
                leftEven += nums[i];
            } else {
                leftOdd += nums[i];
            }
        }
        return count;
    }
}