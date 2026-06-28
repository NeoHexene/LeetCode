class Solution {

    private int checker(int nums[], int low, int mid, int high) {
        int count = 0;
        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && (long) nums[i] > (long) 2 * nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }
        return count;
    }

    private void merge(int[] nums, int low, int mid, int high) {
        int[] c = new int[nums.length];
        int i = 0;
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (nums[left] < nums[right]) {
                c[i++] = nums[left++];
            } else {
                c[i++] = nums[right++];
            }
        }

        while (left <= mid) {
            c[i++] = nums[left++];
        }

        while (right <= high) {
            c[i++] = nums[right++];
        }

        for (int j = low; j <= high; j++) {
            nums[j] = c[j - low];
        }
    }

    private int divide(int nums[], int low, int high) {
        int count = 0;

        if (low >= high) {
            return count;
        }
        int mid = low + (high - low) / 2;

        count += divide(nums, low, mid);
        count += divide(nums, mid + 1, high);
        
        count += checker(nums, low, mid, high);
        
        merge(nums, low, mid, high);

        return count;
    }


    public int reversePairs(int[] nums) {
        return divide(nums, 0, nums.length - 1);
    }
}