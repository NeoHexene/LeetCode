class Solution {

    private void dfs(String num, int target, int idx, String ans, List<String> res, long curr, long prev) {
        
        if (idx == num.length()) {
            if (curr == target) {
                res.add(ans);
            }
            return;
        }

        for (int i = idx; i < num.length(); i++) {

            if (i > idx && num.charAt(idx) == '0') {
                return;
            }

            String currNum = num.substring(idx, i + 1);
            Long digit = Long.parseLong(currNum);

            if (idx == 0) {
                dfs(num, target, i + 1, ans + digit, res, digit, digit);
                continue;
            }

            dfs(num, target, i + 1, ans + '+' + digit, res, curr + digit, digit);

            dfs(num, target, i + 1, ans + '-' + digit, res, curr - digit, - digit);

            dfs(num, target, i + 1, ans + '*' + digit, res, (curr - prev) + (prev * digit), prev * digit);

        }

    }

    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();

        dfs(num, target, 0, "", res, 0l, 0l);

        return res;
    }
}