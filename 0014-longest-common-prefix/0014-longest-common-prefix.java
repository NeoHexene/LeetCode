class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int i = 0;
        while(i < (Math.min(strs[0].length(), strs[strs.length - 1].length())) && strs[0].charAt(i) == strs[strs.length - 1].charAt(i)) {
            i++;
        }
        if (i == 0) {
            return "";
        }
        return strs[0].substring(0, i);
    }
}