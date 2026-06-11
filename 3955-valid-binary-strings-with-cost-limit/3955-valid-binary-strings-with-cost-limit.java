class Solution {

    private List<String> res;

    private void helper(char[] charArr, int n, int k, boolean prevOne, int cost, int idx) {
        if (cost > k) {
            return;
        }
        if (idx == n) {
            res.add(new String(charArr));
            return;
        }
        charArr[idx] = '0';
        helper(charArr, n, k, false, cost, idx + 1);
        if (!prevOne) {
            charArr[idx] = '1';
            helper(charArr, n, k, true, cost + idx, idx + 1);
        }
    }

    public List<String> generateValidStrings(int n, int k) {
        res = new ArrayList<>();
        char[] charArr = new char[n];
        helper(charArr, n, k, false, 0, 0);
        return res;
    }
}