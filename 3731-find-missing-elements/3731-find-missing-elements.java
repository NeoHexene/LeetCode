class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        
        Arrays.sort(nums);
        int idx = 0;
        List<Integer> res = new ArrayList<>();

        for (int i = nums[0]; i < nums[nums.length - 1]; i++) {
            if (nums[idx] == i) {
                idx++;
            } else {
                res.add(i);
            }
        }

        return res;
    }
}