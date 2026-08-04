class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {

        int cell = 100;
        Map<Pair<Integer, Integer>, List<int[]>> grid = new HashMap<>();

        for (int[] pt : points) {
            int cx = Math.floorDiv(pt[0], cell);
            int cy = Math.floorDiv(pt[1], cell);

            Pair<Integer, Integer> pair = new Pair(cx, cy);
            grid.putIfAbsent(pair, new ArrayList<>());
            grid.get(pair).add(pt);
        }

        int[] res = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            
            int[] query = queries[i];

            int qx = query[0];
            int qy = query[1];
            int r = query[2];

            int minx = Math.floorDiv(qx - r, cell);
            int maxx = Math.floorDiv(qx + r, cell);
            int miny = Math.floorDiv(qy - r, cell);
            int maxy = Math.floorDiv(qy + r, cell);

            for (int x = minx; x <= maxx; x++) {
                for (int y = miny; y <= maxy; y++) {

                    Pair<Integer, Integer> pair = new Pair(x, y);
                    List<int[]> list = grid.get(pair);
                    if (list == null) {
                        continue;
                    }

                    for (int pt[] : list) {
                        int dx = pt[0] - qx;
                        int dy = pt[1] - qy;

                        if (dx * dx + dy * dy <= r * r) {
                            res[i]++;
                        }
                    }
                }
            }
        }

        return res;

    }
}