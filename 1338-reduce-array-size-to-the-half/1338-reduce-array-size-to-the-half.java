class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int n = arr.length/2;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b - a));
        for (Integer key : freq.keySet()) {
            pq.add(freq.get(key));
        }
        int count = 0;
        while(!pq.isEmpty() && n > 0) {
            n -= pq.poll();
            count++;
        }
        return count;
    }
}