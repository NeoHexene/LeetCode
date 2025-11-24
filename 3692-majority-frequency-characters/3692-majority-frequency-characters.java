class Solution {
    public String majorityFrequencyGroup(String s) {
        HashMap<Character, Integer> charfreq = new HashMap<>();
        for (char c : s.toCharArray()) {
            charfreq.put(c, charfreq.getOrDefault(c, 0) + 1);
        }
        HashMap<Integer, List<Character>> freqchar = new HashMap<>();
        for (Character c : charfreq.keySet()) {
            List<Character> charlist;
            int frequency = charfreq.get(c);
            if (freqchar.containsKey(frequency)) {
                charlist = freqchar.get(frequency);
            } else {
                charlist = new ArrayList<>();
            }
            charlist.add(c);
            freqchar.put(frequency, charlist);
        }
        List<Character> anslist = new ArrayList<>();
        int ansFreq = 0;
        for (Integer frequency : freqchar.keySet()) {
            List<Character> list = freqchar.get(frequency);
            if (anslist.size() < list.size()) {
                anslist = list;
                ansFreq = frequency;
            } else if (anslist.size() == list.size() && ansFreq < frequency) {
                anslist = list;
                ansFreq = frequency;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : anslist) {
            sb.append(c);
        }
        return sb.toString();
    }
}