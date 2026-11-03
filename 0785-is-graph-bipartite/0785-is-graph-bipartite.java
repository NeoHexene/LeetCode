class Solution {

    private boolean check(int[][] graph, int[] color, int v) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        color[v] = 0;

        while (!q.isEmpty()) {
            
            int curr = q.poll();

            for (int node : graph[curr]) {

                if (color[node] != -1) {
                    if (color[curr] == color[node]) {
                        return false;
                    }
                    continue;
                }

                if (color[curr] == 0) {
                    color[node] = 1;
                } else {
                    color[node] = 0;
                }

                q.offer(node);
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
    
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (check(graph, color, i) == false) {
                    return false;
                }
            }
        }

        return true;
    }
}