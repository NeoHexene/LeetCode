class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        if (arr[0] != 1) {
            Arrays.sort(arr);
        }

        if (arr[0] != 1) {
            arr[0] = 1;
        }

        int n = 2;
        int max = 1;

        for (int i = 1; i < arr.length; i++) {
            if (!(Math.abs(arr[i] - arr[i - 1]) <= 1)) {
                arr[i] = n;
                n++;
            } else {
                n = arr[i] + 1;
            }
            max = Math.max(max, arr[i]);
        }

        return max;
    }
}