class Solution {
    public boolean isIsomorphic(String s, String t) {

        HashMap<Character, Character> st = new HashMap<>();
        HashMap<Character, Character> ts = new HashMap<>();

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if (st.containsKey(s.charAt(i)) && st.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
            if (ts.containsKey(t.charAt(i)) && ts.get(t.charAt(i)) != s.charAt(i)) {
                return false;
            }
            ts.put(t.charAt(i), s.charAt(i));
            st.put(s.charAt(i), t.charAt(i));
        }

        return true;
    }
}