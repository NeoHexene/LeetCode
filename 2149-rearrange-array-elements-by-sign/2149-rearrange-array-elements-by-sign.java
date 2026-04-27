class Solution {

    /*
    a[0] = +ve -> works
    a[0] = -ve -> replace by next positive integer

    a[i] = +ve -> a[i - 1] && a[i + 1] to be -ve if they exist
    a[i] = -ve -> a[i - 1] && a[i + 1] to be +ve if they exist

    So basically evens are +ve and odds are -ve
    */
    public int[] rearrangeArray(int[] nums) {
        int[] pos = new int[nums.length / 2];
        int[] neg = new int[nums.length / 2];
        int p = 0, n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                neg[n++] = nums[i];
            } else {
                pos[p++] = nums[i];
            }
        }

        int res[] = new int[nums.length];
        p = 0;
        n = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                res[i] = pos[p++];
            } else {
                res[i] = neg[n++];
            }
        }

        return res;

    }
}