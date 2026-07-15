class Solution {
    public String frequencySort(String s) {
        
        HashMap<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0) + 1);
        }

        List<Character>[] bucket = new List[s.length() + 1];

        for (int i = 0; i < s.length() + 1; i++) {
            bucket[i] = new ArrayList<>();
        }

        for (Character key : freq.keySet()) {
            bucket[freq.get(key)].add(key);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = s.length(); i > 0; i--) {
            int size = bucket[i].size();
            for (int j = 0; j < size; j++) {
                sb.append(String.valueOf(bucket[i].get(j)).repeat(i));
            }
        }

        return sb.toString();
    }
}