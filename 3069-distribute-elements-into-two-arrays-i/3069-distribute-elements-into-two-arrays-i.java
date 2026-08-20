class Solution {
    public int[] resultArray(int[] nums) {

        int n = nums.length;

        int[] res = new int[n];
        int l = 1, r = n - 2;

        res[0] = nums[0];
        res[n - 1] = nums[1];
 
        for (int i = 2; i < n; i++) {
            if (res[l - 1] > res[r + 1]) {
                res[l++] = nums[i];
            } else {
                res[r--] = nums[i];
            }
        }

        for (int i = l, j = n - 1; i < j; i++, j--) {
            int temp = res[j];
            res[j] = res[i];
            res[i] = temp;
        }

        return res;

    }
}