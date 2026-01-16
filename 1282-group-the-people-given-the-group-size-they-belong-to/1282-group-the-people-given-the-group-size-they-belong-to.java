class Solution {
    public List<List<Integer>> groupThePeople(int[] nums) {
        HashMap<Integer, List<List<Integer>>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                boolean added = false;
                for (List<Integer> list : map.get(nums[i])) {
                    if (list.size() < nums[i]) {
                        list.add(i);
                        added = true;
                        break;
                    }
                }
                if (!added) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    map.get(nums[i]).add(list);
                }
            } else {
                List<List<Integer>> group = new ArrayList<>();
                List<Integer> list = new ArrayList<>();
                list.add(i);
                group.add(list);
                map.put(nums[i], group);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (Integer key : map.keySet()) {
            for (List<Integer> list : map.get(key)) {
                ans.add(list);
            }
        }
        return ans;
    }
}