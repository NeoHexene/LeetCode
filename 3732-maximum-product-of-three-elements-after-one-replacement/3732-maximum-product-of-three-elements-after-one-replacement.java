class Solution {
    public long maxProduct(int[] nums) {
        Arrays.sort(nums);
        if (nums[0] < 0 && nums[nums.length - 1] < 0) {
            int a = nums[0];
            int b = nums[1];
            long c = (long) Math.pow(10,5);
            return (long) a * b * c;
        } else if (nums[0] > 0 && nums[nums.length - 1] > 0) {
            int a = nums[nums.length - 1];
            int b = nums[nums.length - 2];
            long c = (long) Math.pow(10,5);
            return (long) a * b * c;
        } else {
            int count = 0;
            long prodMid = (long) Math.abs((long) nums[nums.length - 1] * (long) nums[0]);
            long prodFirst = 1;
            for (int i = 0; i < nums.length && count < 2; i++) {
                if (nums[i] != 0) {
                    prodFirst = (long) Math.abs(prodFirst * nums[i]);
                    count += 1;
                }
            }
            if (count != 2) {
                prodFirst = 0;
            }
            count = 0;
            long prodEnd = 1;
            for (int i = nums.length - 1; i >= 0 && count < 2; i--) {
                if (nums[i] != 0) {
                    prodEnd = (long) Math.abs(prodEnd * nums[i]);
                    count += 1;
                }
            }
            if (count != 2) {
                prodEnd = 0;
            }
            long finalProd = prodFirst > prodEnd && prodFirst > prodMid ? prodFirst : prodEnd > prodMid ? prodEnd : prodMid;
            return (long) finalProd * (long) Math.pow(10,5);
        }
    }
}