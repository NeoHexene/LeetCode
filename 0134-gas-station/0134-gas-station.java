/*
INTUITION:

We are given two arrays:
- gas[i]  → gas available at station i
- cost[i] → gas required to go from i → i+1

We need to find a starting station such that we can complete the full circle.

-----------------------------------------------------

KEY OBSERVATION (VERY IMPORTANT):

1. If total gas < total cost → IMPOSSIBLE
   (no starting point can work)

2. If total gas >= total cost → a solution ALWAYS exists

-----------------------------------------------------

GREEDY INSIGHT:

If we start at index `start` and at some point our tank becomes negative,
then:
    NONE of the stations between `start` and that failure point can be a valid start

So we:
- reset the starting point to the next index
- reset current tank to 0

-----------------------------------------------------

WHY DOES THIS WORK?

Because if starting at `start` fails at `i`,
then starting at any index between `start` and `i` will fail EVEN EARLIER.

So we skip all those indices.

-----------------------------------------------------

IMPLEMENTED LOGIC:

Step 1:
- Calculate total gas and total cost
- If total gas < total cost → return -1

Step 2:
- Traverse array and maintain a running tank (total)
- If tank becomes negative:
    → reset tank
    → set next index as new starting point

-----------------------------------------------------

TIME COMPLEXITY:
O(n)

SPACE COMPLEXITY:
O(1)
*/

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int gasReq = 0, gasAvai = 0;

        // Step 1: Check feasibility
        for (int i = 0; i < gas.length; i++) {
            gasAvai += gas[i];
            gasReq += cost[i];
        }

        // If total gas is less than total cost → impossible
        if (gasReq > gasAvai) {
            return -1;
        }

        int res = 0;   // potential starting index
        int total = 0; // current tank

        // Step 2: Find valid starting index
        for (int i = 0; i < gas.length; i++) {

            // Add current station's net gas
            total += gas[i] - cost[i];

            // If tank becomes negative → current start is invalid
            if (total < 0) {
                // Reset tank
                total = 0;

                // Try next station as starting point
                res = i + 1;
            }
        }

        return res;
    }
}