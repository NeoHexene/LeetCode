class Solution {
    /*
    [1,1,1], k = 2
    [1,2,3], k = 3

    Brute force:
    Traversing on the array and then checking each pair and lengths.
    TC: O(n^2)
    SC: O(1)

    prefix(l, r) = prefix(r) - prefix(l - 1)
    0, 1, 2, 3
    1, 3, 5, 6
    1, 4, 9, 15

    sum(2, 3) -> prefix(3) - prefix(1)
                 15 - 4 = 11

    sum(i, j) -> prefix(j) - prefix(i - 1)

    k -> prefix(j) - prefix(i - 1)
    prefix(i - 1) -> prefix(j) - k

    */
    public int subarraySum(int[] nums, int k) {
        // check for the length of the input array and if k is 0 then 1.
        // initialize the sum to frequency map.

        Map<Integer, Integer> prefSum = new HashMap<>();
        prefSum.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            if (prefSum.containsKey(sum - k)) {
                count += prefSum.get(sum - k);
            }
            prefSum.put(sum, prefSum.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}