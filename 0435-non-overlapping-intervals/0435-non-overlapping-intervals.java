class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
        
        int end = Integer.MIN_VALUE;
        int count = 0;

        for (int curr[] : intervals) {
            if (end > curr[0]) {
                count++;
            } else {
                end = curr[1];
            }
        }

        return count;
        
    }
}