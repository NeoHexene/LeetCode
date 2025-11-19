class Solution {
    public int minimumDistance(int[] nums) {
        if (nums.length < 3) {
            return -1;
        }
        int min = Integer.MAX_VALUE;
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = null;
            if (map.containsKey(nums[i])) {
                list = map.get(nums[i]);
            } else {
                list = new ArrayList<>();
            }
            list.add(i);
            map.put(nums[i], list);
        }
        for (Integer key : map.keySet()) {
            if (map.get(key).size() >= 3) {
                List<Integer> list = map.get(key);
                for (int i = 0, j = 2; j < list.size(); i++, j++) {
                    int sum = 2 * (list.get(j) - list.get(i));
                    min = Math.min(sum,min);
                }
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }
}