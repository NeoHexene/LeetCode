class Solution {
    public int[] arrayRankTransform(int[] arr) {

        if (arr.length == 0) {
            return new int[0];
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < arr.length; i++) {
            pq.offer(new int[]{arr[i], i});
        }

        int[] ans = new int[arr.length];
        int rank = 1;
        ans[pq.peek()[1]] = rank;
        int prev = pq.poll()[0];

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (prev != curr[0]) {
                rank++;
                prev = curr[0];
            }
            ans[curr[1]] = rank;
        }

        return ans;
    }
}