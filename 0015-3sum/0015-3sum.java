class Solution {

    /*
    [-1, 0, 1, 2, -1, -4] k = 0
    Brute force - O(n3)

    Sort: O(nlogn)
    [-4, -1, -1, 0, 1, 2]

    */

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        Set<List<Integer>> set = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> temp = List.of(nums[i], nums[j], nums[k]);
                    set.add(temp);
                    j++;
                    k--;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return new ArrayList<>(set);
    }
}