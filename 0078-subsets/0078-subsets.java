class Solution {

    private void helper(int[] nums, int idx, List<Integer> temp, List<List<Integer>> res) {

        if (idx == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }

        helper(nums, idx + 1, temp, res);

        temp.add(nums[idx]);
        helper(nums, idx + 1, temp, res);
        temp.remove(temp.size() - 1);
    }


    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();

        helper(nums, 0, new ArrayList<>(), res);

        return res;

    }
}