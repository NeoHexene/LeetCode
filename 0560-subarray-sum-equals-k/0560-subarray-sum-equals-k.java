class Solution {

    /*
    INTUITION:

    We want to count subarrays with sum = k.

    Instead of checking all subarrays (slow), we use a trick:

    At every index, we keep a running sum = sum.

    Now we ask:
    "Have I seen a previous sum such that removing it gives k?"

    That means:
        currentSum - previousSum = k
        previousSum = currentSum - k

    So:
       If (sum - k) has appeared before,
       then we found a subarray ending here with sum = k.

    We use a HashMap to store:
        prefixSum -> how many times we have seen it

    Why frequency?
    Because the same prefix sum can appear multiple times,
    and each occurrence gives a valid subarray.

    KEY MEMORY TRICK:
       "Check (sum - k), then store sum"
    */

    public int subarraySum(int[] nums, int k) {

        // Map: prefix sum -> frequency
        Map<Integer, Integer> prefSum = new HashMap<>();

        // Important:
        // Before starting, sum = 0 has occurred once
        // Helps count subarrays starting from index 0
        prefSum.put(0, 1);

        int sum = 0;   // running sum
        int count = 0; // answer

        for (int num : nums) {

            // Update running sum
            sum += num;

            // Check if we have seen (sum - k) before
            // If yes, those many subarrays end here with sum = k
            if (prefSum.containsKey(sum - k)) {
                count += prefSum.get(sum - k);
            }

            // Store current sum for future use
            prefSum.put(sum, prefSum.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}