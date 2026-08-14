class Solution {

    private void helper(int num, int k, int sum, List<Integer> temp, List<List<Integer>> res) {

        if (sum == 0 && temp.size() == k) {
            res.add(new ArrayList<>(temp));
            return;
        }
        if (num == 10 || sum < 0 || temp.size() == k) {
            return;
        }

        temp.add(num);
        helper(num + 1, k, sum - num, temp, res);
        temp.remove(temp.size() - 1);
        helper(num + 1, k, sum, temp, res);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {

        if (n == 1 || n > 45) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();

        helper(1, k, n, new ArrayList<>(), res);

        return res;
    }
}