class Solution {

    private Set<Integer> ans = new HashSet<>();

    private void helper(int digit,  int[] nums, Set<Integer> visited, int size) {
	    if (size == 3) {
	        ans.add(digit);
	        return;
        }
        for (int j = 0; j < nums.length; j++) {
	        if ((size == 2 && nums[j] % 2 == 1) || visited.contains(j)) {
	            continue;
            }
	        visited.add(j);
            helper ((digit * 10) + nums[j] , nums, visited, size + 1);
            visited.remove(j);
        }

    }

    public int[] findEvenNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                Set<Integer> visited = new HashSet<>();
                visited.add(i);
                helper(nums[i], nums, visited, 1);
            }
        }
        int[] res = new int[ans.size()];
        int i = 0;
        for (Integer data : ans) {
            res[i++] = data;
        }
        Arrays.sort(res);
        return res;

    }
}