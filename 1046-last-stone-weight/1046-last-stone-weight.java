class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < stones.length; i++) {
            maxHeap.add(stones[i]);
        }

        while (!maxHeap.isEmpty() && maxHeap.size() > 1) {
            int a = maxHeap.remove();
            int b = maxHeap.remove();
            if (a != b) {
                int sum = Math.abs(a - b);
                maxHeap.add(sum);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.remove();
    }
}