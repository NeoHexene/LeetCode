class Solution {
    public int countMonobit(int n) {
        int x = 1;
        int count = 1;
        while (true) {
            long num = (long) Math.pow(2, x) - 1;
            x += 1;
            if (num <= n) {
                count += 1;
            } else {
                break;
            }
        }
        return count;
    }
}