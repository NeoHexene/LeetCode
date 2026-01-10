class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int low, int high) {
        if (low >= high) return 0;
        int mid = low + (high - low) / 2;
        int count = mergeSort(nums, low, mid) + mergeSort(nums, mid + 1, high);
        count += merge(nums, low, mid, high);
        return count;
    }

    private int merge(int[] nums, int low, int mid, int high) {
        int count = 0;
        int a[] = new int[high - low + 1];
        int idx = 0;

        int p = low, q = mid + 1;
        while (p <= mid && q <= high) {
            if ((long)nums[p] > (long)2 * nums[q]) {
                count += mid - p + 1;
                q++;
            } else {
                p++;
            }
        }

        p = low; q = mid + 1;
        while (p <= mid && q <= high) {
            if (nums[p] < nums[q]) {
                a[idx++] = nums[p++];
            } else {
                a[idx++] = nums[q++];
            }
        }
        while (p <= mid) {
            a[idx++] = nums[p++];
        }
        while (q <= high) {
            a[idx++] = nums[q++];
        }

        System.arraycopy(a, 0, nums, low, high - low + 1);

        return count;
    }
}