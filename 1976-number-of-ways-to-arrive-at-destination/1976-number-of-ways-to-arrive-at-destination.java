class Solution {

    private final static int MOD = 1000000007;

    public int countPaths(int n, int[][] roads) {

        List<List<int[]>> adj = new ArrayList<>();
        long[] time = new long[n];
        int[] ways = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            time[i] = Long.MAX_VALUE;
            ways[i] = 0;
        }

        for (int[] road : roads) {
            adj.get(road[0]).add(new int[]{road[1], road[2]});
            adj.get(road[1]).add(new int[]{road[0], road[2]});
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return Long.compare(a[1], b[1]);
            }
            return Long.compare(a[0], b[0]);
        });

        time[0] = 0;
        ways[0] = 1;
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {

            long[] curr = pq.poll();
            long currtime = curr[0];
            int currnode = (int) curr[1];

            for (int[] node : adj.get(currnode)) {

                int nodeval = node[0];
                long nodetime = node[1];

                long newtime = nodetime + currtime;

                if (newtime < time[nodeval]) {
                    time[nodeval] = newtime;
                    ways[nodeval] = ways[currnode];
                    pq.offer(new long[]{newtime, nodeval});
                } else if (newtime == time[nodeval]) {
                    ways[nodeval] = (ways[nodeval] + ways[currnode]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}