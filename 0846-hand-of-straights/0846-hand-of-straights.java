class Solution {
    public boolean isNStraightHand(int[] hand, int k) {
        if (hand.length % k != 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : hand) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        Arrays.sort(hand);
        for (int n : hand) {
            if (map.get(n) > 0) {
                for (int i = n + 1; i < n + k; i++) {
                    if (map.getOrDefault(i, 0) == 0) {
                        return false;
                    }
                    map.put(i, map.get(i) - 1);
                }
                map.put(n, map.get(n) - 1);
            }
        }
        return true;
    }
}