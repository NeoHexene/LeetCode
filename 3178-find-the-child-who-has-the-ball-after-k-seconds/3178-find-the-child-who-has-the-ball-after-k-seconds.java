class Solution {
    public int numberOfChild(int n, int k) {
        boolean up = true;
        int pointer = 0;
        for (int i = 1; i <= k; i++) {
            if (up) {
                pointer++;
            } else {
                pointer--;
            }

            if (pointer == n - 1) {
                up = false;
            }
            if (pointer == 0) {
                up = true;
            }
        }
        return pointer;
    }
}