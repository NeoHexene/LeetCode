/*
DFS:

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
*/

class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int n = graph.length;

        List<List<Integer>> reverseadj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            reverseadj.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j : graph[i]) {
                reverseadj.get(j).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();

        while (!q.isEmpty()) {

            int curr = q.poll();
            res.add(curr);

            for (int node : reverseadj.get(curr)) {
                indegree[node]--;
                if (indegree[node] == 0) {
                    q.offer(node);
                }
            }
        }

        Collections.sort(res);

        return res;
    }
}