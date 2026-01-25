class Solution {
    public int[] rotateElements(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                dq.addLast(nums[i]);
            }
        }
        while (!dq.isEmpty() && k > 0) {
            int first = dq.removeFirst();
            dq.addLast(first);
            k--;
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                res[i] = dq.removeFirst();
            } else {
                res[i] = nums[i];
            }
        }
        return res;
    }
}