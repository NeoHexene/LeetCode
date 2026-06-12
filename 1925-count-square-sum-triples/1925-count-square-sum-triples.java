class Solution {
    public int countTriples(int n) {
        int count = 0;

        for (int i = 1; i <= n - 1; i++) {
            for (int j = 1; j <= n - 1; j++) {
                int c = (int)Math.sqrt((i * i) + (j * j));
                if (c <= n && (c * c) == ((i * i) + (j * j))) {
                    count += 1;
                }
            }
        }

        return count;
    }
}