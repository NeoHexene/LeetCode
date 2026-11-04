class Solution {

    private boolean dfs(int[][] graph, int v, boolean[] visited, boolean[] pathvisited, boolean[] check) {

        visited[v] = true;
        pathvisited[v] = true;

        for (int node : graph[v]) {
            
            if (!visited[node]) {

                if (dfs(graph, node, visited, pathvisited, check)) {
                    check[v] = false;
                    return true;
                }

            } else if (pathvisited[node]) {
                check[v] = false;
                return true;
            }
        }

        check[v] = true;
        pathvisited[v] = false;
    
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int n = graph.length;

        boolean[] visited = new boolean[n];
        boolean[] pathvisited = new boolean[n];
        boolean[] check = new boolean[n];

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {
                dfs(graph, i, visited, pathvisited, check);
            }
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (check[i]) {
                res.add(i);
            }
        }

        return res;
    }
}