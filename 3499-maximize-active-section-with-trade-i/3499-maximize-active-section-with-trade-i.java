class Solution {

    /*

    So here we are given the keywords like contiguous 1's and 0's which tell us that it is not an interval problem.

    Here we will segment the entire array in the segments of 0-run | 1-run | 0-run 

    So to count extra (convertible) 1's, they need to be in the segment of 0's i.e., it should be as below
    0-run | 1-run | 0-run.

    For this we need to store the length of the "immediate" previous 0's. So the total number of current 0's and previous 0's will give us the total gains for that segment of 0 - 1 - 0 run. Using this strategy we can keep track of 
    maximum and then add that maximum to the total number of 1's already present.

    */

    public int maxActiveSectionsAfterTrade(String s) {

        int count1 = 0, n = s.length();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                count1++;
            }
        }

        int i = 0;
        int bestGain = 0;
        int prev = Integer.MIN_VALUE;
        int curr = 0;

        while (i < n) {
            int start = i;
            while (i < n && s.charAt(i) == s.charAt(start)) {
                i++;
            }
            if (s.charAt(start) == '0') {
                curr = i - start;
                if (prev != Integer.MIN_VALUE) {
                    bestGain = Math.max(bestGain, curr + prev);
                }
                prev = curr;
            }
        }

        return bestGain + count1;
    }
}