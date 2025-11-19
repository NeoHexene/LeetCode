class Solution {
    public int minimumDistance(int[] nums) {
        if (nums.length < 3) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                List<Integer> list = map.get(nums[i]);
                list.add(i);
                map.put(nums[i], list);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        for (int key: map.keySet()) {
            if (map.get(key).size() >= 3) {
                List<Integer> list = map.get(key);
                for (int i = 0, j = 1, k = 2; k < list.size(); i++, j++, k++) {
                    int sum = 2 * Math.abs(list.get(i) - list.get(k));
                    min = Math.min(sum,min);
                }
            }
        }
        if(min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }
}