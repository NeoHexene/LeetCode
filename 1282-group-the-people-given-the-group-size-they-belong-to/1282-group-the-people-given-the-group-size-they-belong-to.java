class Solution {
    public List<List<Integer>> groupThePeople(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            List<Integer> group = map.get(nums[i]);
            group.add(i);
            if (group.size() == nums[i]) {
                ans.add(group);
                map.remove(nums[i]);
            }
        }
        return ans;
    }
}