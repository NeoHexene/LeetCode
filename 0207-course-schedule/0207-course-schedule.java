class Solution {

    private Map<Integer, List<Integer>> map = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int n, int[][] prerequisites) {
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int curr[] : prerequisites) {
            map.get(curr[0]).add(curr[1]);
        }
        for (int i = 0; i < n; i++) {
            if (!dfs(i)) return false;
        }
        return true;
    }

    private boolean dfs(int c) {
        if (visited.contains(c)) {
            return false;
        }
        if (map.get(c).isEmpty()) {
            return true;
        }
        visited.add(c);
        for (int pre : map.get(c)) {
            if (!dfs(pre)) {
                return false;
            }
        }
        visited.remove(c);
        map.put(c, new ArrayList<>());
        return true;
    }
}