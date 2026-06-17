class Solution {

    private boolean isValid(int[] nums1, int[] nums2, int x) {
        int count = 0;
        int p1 = 0, p2 = 0;
        while (p2 < nums2.length && p1 < nums1.length) {
            if (nums1[p1] + x != nums2[p2]) {
                if (count == 2) {
                    return false;
                }
                count += 1;
                p1++;
            } else {
                p1++;
                p2++;
            }
        }
        return true;
    }

    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int[] possibilities = new int[3];
        for (int i = 0; i < 3; i++) {
            possibilities[i] = nums2[0] - nums1[i];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (isValid(nums1, nums2, possibilities[i])) {
                res = Math.min(res, possibilities[i]);
            }
        }
        return res;
    }
}