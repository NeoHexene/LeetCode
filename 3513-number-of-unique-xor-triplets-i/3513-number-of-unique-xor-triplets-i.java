class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if (n < 3) {
            return n;
        }

        int i = 1;
        int mul = 2;

        while (mul <= n) {
            i++;
            mul *= 2;
        }

        i--;
        mul = 2;

        while (i > 0) {
            i--;
            mul *= 2;
        }

        return mul;

    }
}