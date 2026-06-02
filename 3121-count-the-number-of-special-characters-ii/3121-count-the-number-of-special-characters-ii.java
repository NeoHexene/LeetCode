class Solution {
    public int numberOfSpecialChars(String word) {
        Map<Character, Integer> lastOccurrenceOfLowercase = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (Character.isLowerCase(c)) {
                lastOccurrenceOfLowercase.put(c, i);
            }
        }
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            char sc = Character.toLowerCase(c);
            if (Character.isUpperCase(c) && lastOccurrenceOfLowercase.containsKey(sc)) {
                if (i > lastOccurrenceOfLowercase.get(sc)) {
                    count += 1;
                }
                lastOccurrenceOfLowercase.remove(sc);
            }
        }
        return count;
    }
}