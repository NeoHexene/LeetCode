class Solution {

    private List<String> res = new ArrayList<>();

    private void helper(StringBuilder sb, int idx, int total, int k, int n, boolean prevOne) {
        if (total > k) {
            return;
        }
        if (sb.length() == n) {
            res.add(sb.toString());
            return;
        }

        System.out.println("String: " + sb.toString() + " Total: " + total);

        if (!prevOne) {
            sb.append(1);
            helper(sb, idx + 1, total + idx, k, n, true);
            sb.deleteCharAt(sb.length() - 1);
        }
        sb.append(0);
        helper(sb, idx + 1, total, k, n, false);
        sb.deleteCharAt(sb.length() - 1);
    }

    public List<String> generateValidStrings(int n, int k) {
        helper(new StringBuilder(), 0, 0, k, n, false);
        return res;
    }
}