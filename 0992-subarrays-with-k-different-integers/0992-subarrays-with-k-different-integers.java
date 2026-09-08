class Solution {

    private int subarraysWithLessThanOrEqualToKDistinct(int[] nums, int k) {

        if (k < 0) {
            return 0;
        }

        int l = 0, r = 0, count = 0;
        Map<Integer, Integer> map = new HashMap<>();

        while (r < nums.length) {
            
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while (map.size() > k) {
                map.put(nums[l], map.getOrDefault(nums[l], 0) - 1);

                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }

                l++;
            }

            count += (r - l + 1);

            r++;

        }

        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        int res = subarraysWithLessThanOrEqualToKDistinct(nums, k) - subarraysWithLessThanOrEqualToKDistinct(nums, k - 1);

        return res;
    }
}