class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;

        long res[] = new long[n];

        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        
        for (List<Integer> list : map.values()) {
            long sum = 0;

            for (int x : list) {
                sum += x;
            }

            long leftSum = 0;
            int m = list.size();

            for (int i = 0; i < m; i++) {
                long rightSum = sum - leftSum - list.get(i);

                long left = (long) list.get(i) * i - leftSum;
                long right = rightSum - (long) list.get(i) * (m - i - 1);

                res[list.get(i)] = left + right;

                leftSum += list.get(i);

            }
        }
        return res;
    }
}