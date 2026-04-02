class Solution {

    /*
    Unimplemented approach:
    Sort each and every string and then map them into their respective keys (sorted strings)
    for example:
    eat, tea, ate -> aet
    nat, tan -> ant

    Time Complexity: O(m * nlogn) i.e. iterating over the input and sorting of the strings
    Space Complexity: O(mn) i.e. the length of the string and the lenght of the map
    */

    public List<List<String>> groupAnagrams(String[] strs) {
        
        // This map will store:
        // key   -> character frequency signature (as String)
        // value -> list of words that share this signature (i.e., anagrams)
        HashMap<String, List<String>> map = new HashMap<>();

        // Iterate over each string in input
        for (String s : strs) {

            // Create a frequency array for 26 lowercase letters
            // chars[0] -> count of 'a', chars[1] -> 'b', ..., chars[25] -> 'z'
            int[] chars = new int[26];

            // Fill the frequency array for current string
            for (int i = 0; i < s.length(); i++) {
                chars[s.charAt(i) - 'a']++;
            }

            // Convert the frequency array into a String key
            // Why? Because arrays cannot be used directly as HashMap keys
            // (they compare by reference, not by value)
            String key = Arrays.toString(chars);

            // If this key does not exist in map, create a new list
            map.putIfAbsent(key, new ArrayList<>());

            // Add the current string to the corresponding anagram group
            map.get(key).add(s);
        }

        // Convert map values (which are lists of anagrams) into result list
        return new ArrayList<>(map.values());
    }
}