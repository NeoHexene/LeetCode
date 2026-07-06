class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
                if (a[0] == b[0]) {
                    return Integer.compare(b[1], a[1]);
                }
                return Integer.compare(a[0], b[0]);
                }
            );

        List<int[]> res = new ArrayList<>();
        int[] prev = intervals[0];
        
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            System.out.println("Prev: " + prev[0] + ", " + prev[1] + " Curr: " + curr[0] + ", " + curr[1]);
            if (prev[1] >= curr[1]) {
                continue;
            } else {
                res.add(prev);
                prev = curr;
            }
        }

        res.add(prev);

        return res.size();
    }
}