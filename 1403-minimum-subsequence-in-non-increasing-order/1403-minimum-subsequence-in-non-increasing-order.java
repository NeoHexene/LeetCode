class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        int[] prefix = new int[nums.length + 1];
        Arrays.sort(nums);
        prefix[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        int total = prefix[nums.length];
        int i = nums.length;
        while (prefix[i] >= total - prefix[i] && i >= 0) {
            i--;
        }
        List<Integer> ans = new ArrayList<>();
        for(int j = nums.length - 1; j >= i; j--) {
            ans.add(nums[j]);
        }
        return ans;
    }
}