class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>(k);
        int i = 0;
        int j = 0;
        while (j <= k && j < nums.length) {
            if (!set.add(nums[j++])) {
                return true;
            }
        }
        while (j < nums.length) {
            set.remove(nums[i++]);
            if (!set.add(nums[j++])) {
                return true;
            }
        }
        return false;
    }
}