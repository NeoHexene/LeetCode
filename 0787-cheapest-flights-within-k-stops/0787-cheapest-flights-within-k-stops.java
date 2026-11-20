class Solution {

    public int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {

        int[] cost = new int[n];
        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            cost[i] = Integer.MAX_VALUE;
        }

        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{0, src, 0}); // cost, node, stops
        cost[src] = 0;

        while (!q.isEmpty()) {

            int[] curr = q.poll();
            int currcost = curr[0];
            int currnode = curr[1];
            int currstop = curr[2];

            if (currnode == dest) {
                continue;
            }

            if (currstop > k) {
                continue;
            }

            for (int[] next : adj.get(currnode)) {

                int nextnode = next[0];
                int nextcost = next[1];

                if (currcost + nextcost < cost[nextnode]) {
                    q.offer(new int[]{currcost + nextcost, nextnode, currstop + 1});
                    cost[nextnode] = currcost + nextcost;
                }
            }
        }

        return cost[dest] == Integer.MAX_VALUE ? -1 : cost[dest];
    }
}