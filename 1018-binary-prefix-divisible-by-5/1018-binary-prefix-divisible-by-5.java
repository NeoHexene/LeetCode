class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int remainder = nums[0];
        if (remainder == 0) {
            ans.add(true);
        } else {
            ans.add(false);
        }
        for(int i = 1; i < nums.length; i++) {
            remainder = (remainder * 2 + nums[i]) % 5;
            if (remainder == 0) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }
}