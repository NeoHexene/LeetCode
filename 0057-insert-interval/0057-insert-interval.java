class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        List<int[]> temp = new ArrayList<>();
        int n = intervals.length;
        int i = 0;

        // Non overlapping left side
        while (i < n && intervals[i][1] < newInterval[0]) {
            temp.add(intervals[i]);
            i++;
        }

        // Overlapping middle
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        temp.add(newInterval);

        // Non overlapping right side
        while (i < n) {
            temp.add(intervals[i]);
            i++;
        }

        int[][] res = new int[temp.size()][2];

        for (int j = 0; j < temp.size(); j++) {
            res[j] = temp.get(j);
        }

        return res;
    }
}