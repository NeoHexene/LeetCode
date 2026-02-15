class Solution {
    public int firstUniqueFreq(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        HashMap<Integer, List<Integer>> freq = new HashMap<>();
        for (Integer key : map.keySet()) {
            List<Integer> num;
            if (freq.containsKey(map.get(key))) {
                num = freq.get(map.get(key));
            } else {
                num = new ArrayList<>();
            }
            num.add(key);
            freq.put(map.get(key), num);
        }
        List<Integer> res = new ArrayList<>();
        for (Integer key : freq.keySet()) {
            if (freq.get(key).size() == 1) {
                res.add(freq.get(key).get(0));
            }
        }
        if (res.size() > 0) {
            for (int n : nums) {
                int idx = res.indexOf(n);
                if (idx != -1) {
                    return n;
                }
            }
        }
        return -1;
    }
}