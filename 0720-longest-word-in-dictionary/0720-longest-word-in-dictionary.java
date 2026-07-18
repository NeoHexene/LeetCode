class Solution {
    public String longestWord(String[] words) {
        String res = "";
        int max = 0;
        Map<String, Boolean> map = new HashMap<>();

        Arrays.sort(words);

        for (String word : words) {

            if (word.length() == 1 || map.containsKey(word.substring(0, word.length() - 1))) {
                map.put(word, map.get(word.substring(0, word.length() - 1)));
                if (word.length() > max) {
                    max = word.length();
                    res = word;
                }

            }
        }

        return res;

    }
}