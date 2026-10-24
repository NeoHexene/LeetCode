class Solution {

    private void bfs(int[][] isConnected, int V, boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();
        q.offer(V);
        visited[V] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int i = 0; i < isConnected[curr].length; i++) {
                
                if (isConnected[curr][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;

        for (int i = 0; i < isConnected.length; i++) {
            
            if (!visited[i]) {
                bfs(isConnected, i, visited);
                count++;
            }
        }

        return count;
    }
}