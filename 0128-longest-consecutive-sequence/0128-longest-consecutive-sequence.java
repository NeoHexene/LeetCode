class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
        }
        int prev = pq.poll();
        int currLen = 1;
        int maxLen = 1;
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            if (curr == prev) {
                continue;
            } else if (curr - prev == 1) {
                currLen += 1;
                prev = curr;
            } else {
                prev = curr;
                currLen = 1;
            }
            maxLen = Math.max(maxLen, currLen);
        }
        return maxLen;
    }
}