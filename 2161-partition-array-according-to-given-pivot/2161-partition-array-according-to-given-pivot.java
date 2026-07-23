class Solution {
    public int[] pivotArray(int[] nums, int pivot) {

        int low = 0;
        int high = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > pivot) {
                high++;
            } else if (nums[i] < pivot) {
                low++;
            }
        }

        int i = 0;
        int j = i + low;
        int k = j + nums.length - low - high;

        int[] res = new int[nums.length];

        for (int idx = 0; idx < nums.length; idx++) {
            if (nums[idx] > pivot) {
                res[k++] = nums[idx];
            } else if (nums[idx] < pivot) {
                res[i++] = nums[idx];
            } else {
                res[j++] = nums[idx];
            }
        }

        return res;

    }
}