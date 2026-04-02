class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length < 1) {
            return 0;
        }
        
        int maxProfit = 0;
        int buy = prices[0];
        
        for (int i = 1; i < prices.length; i++) {
            if (buy > prices[i]) {
                buy = prices[i];
            } else {
                maxProfit = Math.max(maxProfit,prices[i] - buy);
            }
        }
        
        return maxProfit;
    }
}