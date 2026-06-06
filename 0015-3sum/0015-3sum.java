class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Set<String> check = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (map.containsKey(0 - nums[i] - nums[j])) {
                    int k = map.get(0 - nums[i] - nums[j]);
                    int[] curr = new int[]{nums[i], nums[j], nums[k]};
                    Arrays.sort(curr);
                    String s = curr[0] + " " + curr[1] + " " + curr[2];
                    if (!check.contains(s)) {
                        check.add(s);
                        List<Integer> temp = List.of(nums[i], nums[j], nums[k]);
                        res.add(temp);
                    }
                } else {
                    map.put(nums[j], j);
                }
            }
        }

        return res;
    }
}