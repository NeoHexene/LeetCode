class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int buy = INT_MAX;
        int profit = 0;

        for (auto p : prices) {
            if (buy > p) {
                buy = p;
            }
            profit = max(profit, p - buy);
        }

        return profit;
    }
};