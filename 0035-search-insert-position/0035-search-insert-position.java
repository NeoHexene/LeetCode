class Solution {
    public int searchInsert(int[] array, int target) {
        // int low = 0, high = nums.length - 1;

        // while (low <= high) {
        //     int mid = low + (high - low) / 2;

        //     if (nums[mid] == target) {
        //         return mid;
        //     }

        //     if (nums[mid] > target) {
        //         high = mid - 1;
        //     } else {
        //         low = mid + 1;
        //     }
        // }

        // return high + 1;

        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (array[mid] > target) {
                end = mid - 1;
            } else if (array[mid] < target) {
                start = mid + 1;
            } else if (array[mid] == target) {
                return mid;
            }
        }
        return start;

    }
}