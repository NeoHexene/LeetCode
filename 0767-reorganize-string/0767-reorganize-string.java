class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            if (map.get(s.charAt(i)) > (s.length() + 1) / 2) {
                return "";
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[0], a[0]));
        for (Character key : map.keySet()) {
            pq.offer(new int[]{map.get(key), key});
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] temp1 = pq.poll();
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == (char) (temp1[1])) {
                int[] temp2 = pq.poll();
                sb.append((char) (temp2[1]));
                if (temp2[0] - 1 > 0) {
                    pq.offer(new int[]{temp2[0] - 1, temp2[1]});
                }
                pq.offer(temp1);
            } else {
                sb.append((char) (temp1[1]));
                if (temp1[0] - 1 > 0) {
                    pq.offer(new int[]{temp1[0] - 1, temp1[1]});
                }
            }
        }
        return sb.toString();
    }
}