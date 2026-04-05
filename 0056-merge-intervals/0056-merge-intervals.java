class Solution {
    public int[][] merge(int[][] intervals) {
        /*
        INTUITION:
        We need to merge overlapping intervals.

        First thought:
        - If intervals are not sorted, it is hard to know which ones overlap.
        - So we sort them by starting point.

        After sorting:
        - If current interval overlaps with previous one, merge them.
        - If not, store the previous one and move to the next.

        This works because sorted intervals make overlapping easy to detect.
        TC: O(nlogn) because of the sorting
        SC: O(n) because of the mergeList
        */

        // Sort intervals by starting point
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // This list will store the final merged intervals
        List<int[]> mergeList = new ArrayList<>();

        // Start with the first interval as the previous one
        int[] prev = intervals[0];

        // Compare every next interval with the previous merged interval
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];

            // If current interval starts before or at the end of previous interval,
            // they overlap, so merge them
            if (prev[1] >= curr[0]) {
                prev[1] = Math.max(prev[1], curr[1]);
            } else {
                // No overlap, so save previous interval
                mergeList.add(prev);

                // Move to current interval
                prev = curr;
            }
        }

        // Add the last interval after loop ends
        mergeList.add(prev);

        // Convert list to 2D array and return
        return mergeList.toArray(new int[mergeList.size()][2]);
    }
}