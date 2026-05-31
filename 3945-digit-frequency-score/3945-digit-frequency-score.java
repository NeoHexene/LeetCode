class Solution {
    public int digitFrequencyScore(int n) {
        String s = String.valueOf(n);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
             map.put(s.charAt(i) - '0', map.getOrDefault(s.charAt(i) - '0', 0) + 1);
        }

        int score = 0;

        for (Integer key : map.keySet()) {
            score += (key * map.get(key));
        }

        return score;
    }
}