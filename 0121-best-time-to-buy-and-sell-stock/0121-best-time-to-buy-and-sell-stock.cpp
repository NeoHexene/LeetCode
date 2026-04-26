/*
INTUITION:

We want to maximize profit with one buy and one sell.

At any day:
- If we sell today, profit = current price - minimum price seen before today

So the goal is:
    track the minimum price so far (best buy)
    compute profit at each step

-----------------------------------------------------

CORE IDEA:

- Always try to buy at the lowest price seen so far
- For each price, compute profit if we sell today

-----------------------------------------------------

APPROACH:

1. Initialize:
   - buy = INT_MAX → minimum price seen so far
   - profit = 0 → maximum profit

2. Traverse prices:
   - update buy = min(buy, current price)
   - compute profit = max(profit, current price - buy)

-----------------------------------------------------

EXAMPLE:

prices = [7,1,5,3,6,4]

Step-by-step:

p=7 → buy=7 → profit=0
p=1 → buy=1 → profit=0
p=5 → profit=4
p=3 → profit=4
p=6 → profit=5
p=4 → profit=5

Answer = 5

-----------------------------------------------------

EDGE CASES:

1. Decreasing prices:
   → profit remains 0 (no transaction)

2. Single element:
   → profit = 0

-----------------------------------------------------

TIME COMPLEXITY:
O(n)

SPACE COMPLEXITY:
O(1)

-----------------------------------------------------

PATTERN:

Greedy + prefix minimum
*/

class Solution {
public:
    int maxProfit(vector<int>& prices) {

        int buy = INT_MAX; // lowest price so far
        int profit = 0;    // max profit

        for (auto p : prices) {

            // Update minimum price
            if (buy > p) {
                buy = p;
            }

            // Calculate profit if sold today
            profit = max(profit, p - buy);
        }

        return profit;
    }
};