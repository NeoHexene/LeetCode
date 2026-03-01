class Solution {
    public int minCost(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        int res = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr <= 1 ) {
                continue;
            }
            int fh = curr/2;
            int sh = curr - fh;
            res += (fh * sh);
            q.add(fh);
            q.add(sh);
        }
        return res;
    }
}