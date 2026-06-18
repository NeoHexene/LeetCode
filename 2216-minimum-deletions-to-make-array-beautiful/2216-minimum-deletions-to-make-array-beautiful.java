class Solution {
    public int minDeletion(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int idx = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (idx % 2 != 0 && list.get(idx - 1) == nums[i]) {
                count++;
                continue;
            } else {
                list.add(nums[i]);
                idx++;
            }
        }
        if (list.size() % 2 != 0) {
            count++;
        }
        return count;
    }
}