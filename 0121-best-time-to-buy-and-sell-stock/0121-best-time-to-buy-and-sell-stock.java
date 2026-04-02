class Solution {

    // Time Complexity: O(n)
    // Space Complexity: O(1);
    
    public int maxProfit(int[] prices) {
        
        // If the array is empty, no transactions can be made
        if (prices.length < 1) {
            return 0;
        }

        // This will store the maximum profit we can achieve
        int maxProfit = 0;

        // Assume we buy on the first day initially
        int buy = prices[0];

        // Start checking from day 1 (since day 0 is already considered as buy)
        for (int i = 1; i < prices.length; i++) {

            // If we find a lower price than our current buying price,
            // update buy to this new lower price (better buying opportunity)
            if (buy > prices[i]) {
                buy = prices[i];
            } else {
                // Otherwise, calculate profit if we sell today
                // profit = current price - buying price

                // Update maxProfit if this profit is higher than previous ones
                maxProfit = Math.max(maxProfit, prices[i] - buy);
            }
        }

        // Return the maximum profit found
        return maxProfit;
    }
}