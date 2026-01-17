class Solution {

    private void getAllCombinations(int[] candidates, int target, int index, List<Integer> temp, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            temp.add(candidates[i]);
            getAllCombinations(candidates, target - candidates[i], i + 1, temp, ans);
            temp.remove(temp.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        getAllCombinations(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }
}