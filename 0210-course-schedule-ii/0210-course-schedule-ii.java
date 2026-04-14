class Solution {

    List<Integer> ans = new ArrayList<>();
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    Set<Integer> completed = new HashSet<>();

    public int[] findOrder(int n, int[][] prereqs) {
        for (int c = 0; c < n; c++) {
            map.put(c, new ArrayList<>());
        }
        for (int curr[] : prereqs) {
            map.get(curr[0]).add(curr[1]);
        }
        for (int c = 0; c < n; c++) {
            if (!dfs(c)) {
                return new int[]{};
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    private boolean dfs(int c) {
        if (visited.contains(c)) {
            return false;
        }
        if (completed.contains(c)) {
            return true;
        }
        visited.add(c);
        for (int pre : map.get(c)) {
            if (!dfs(pre)) {
                return false;
            }
        }
        visited.remove(c);
        completed.add(c);
        ans.add(c);
        return true;
    }
}