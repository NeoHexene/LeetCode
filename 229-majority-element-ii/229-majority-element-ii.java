class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap < Integer, Integer > m = new HashMap < Integer, Integer> ();
        ArrayList < Integer > ans = new ArrayList <Integer> ();
        for (int i = 0 ; i < nums.length ; i++) {
            m.put(nums[i], m.getOrDefault(nums[i], 0) + 1);
        }
        for (int i : m.keySet()) {
            if (m.get(i) > (nums.length/3)) {
                ans.add(i);
            }
        }
        return ans;
    }
}