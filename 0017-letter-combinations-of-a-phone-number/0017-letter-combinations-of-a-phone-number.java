class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits.isEmpty()) {
            return res;
        }
        
        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(0, new StringBuilder(), digits, res, map);

        return res;
    }

    private void backtrack(int idx, StringBuilder build, String digits, List<String> res, Map<Character,String> map) {
        if (idx == digits.length()) {
            res.add(build.toString());
            return;
        }
        char[] chars = map.get(digits.charAt(idx)).toCharArray();
        for (char c : chars) {
            build.append(c);
            backtrack (idx + 1, build, digits, res, map);
            build.deleteCharAt(build.length() - 1);
        }
    }
}