class Solution {
    public int minGroupsForValidAssignment(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int min = nums.length;
        for (int val : map.values()) {
            min = Math.min(min, val);
        }
        // why did we implement this for loop, explain please @chatgpt.
        for (int size = min; size > 0; size--) {
            int groups = groupify(map, size);
            if (groups > 0) {
                return groups;
            }
        }
        return nums.length;
    }

    private int groupify(Map<Integer, Integer> map, int size) {
        int groups = 0;
        int next = size + 1;
        for (int val : map.values()) {
            int numGroups = val / next;
            int remaining = val % next;
            if (remaining == 0) {
                groups += numGroups;
            } else if (numGroups >= size -  remaining) { // I did not understand this, explain me this as well @chatgpt.
                groups += numGroups + 1;
            } else {
                return 0;
            }
        }
        return groups;
    }
}