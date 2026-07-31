class Solution {
    public int minimumPushes(String word) {
        
        int n = word.length();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(word.charAt(i) - 'a', map.getOrDefault(word.charAt(i) - 'a', 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {if (a[1] == b[1]) {
            return Integer.compare(b[0], a[0]);
        }
        return Integer.compare(b[1], a[1]);});

        for (Integer key : map.keySet()) {
            pq.offer(new int[]{key, map.get(key)});
        }

        int count = 0;
        int res = 0;

        while (!pq.isEmpty()) {
            int curr[] = pq.poll();
            res += ((count / 8 + 1) * curr[1]);
            count++;
        }

        return res;
    }
}