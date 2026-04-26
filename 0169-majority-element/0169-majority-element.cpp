/*
INTUITION:

We are guaranteed that a majority element exists (> n/2 times).

Key idea (Boyer-Moore Voting):
- Think of "cancelling out" different elements.
- Pair one occurrence of the current candidate with a different element → they cancel.
- Since the majority element appears more than all others combined, it cannot be fully cancelled.

So the remaining candidate after one pass must be the majority.

-----------------------------------------------------

HOW IT WORKS:

Maintain:
- ele   → current candidate
- count → "vote balance" for the candidate

Traverse the array:
1) If count == 0:
      choose current number as new candidate
2) If nums[i] == ele:
      count++
3) Else:
      count--

-----------------------------------------------------

WHY THIS WORKS:

- Every time we see a different element, it cancels one vote of the candidate.
- Only the majority element can survive all cancellations.

-----------------------------------------------------

EXAMPLE:

nums = [2,2,1,1,1,2,2]

i=0: ele=2, count=1
i=1: same → count=2
i=2: diff → count=1
i=3: diff → count=0
i=4: count=0 → ele=1, count=1
i=5: diff → count=0
i=6: count=0 → ele=2, count=1

Result: 2

-----------------------------------------------------

EDGE CASE NOTE:

If majority element is NOT guaranteed:
→ you must do a second pass to verify the candidate.

-----------------------------------------------------

TIME COMPLEXITY:
O(n)

SPACE COMPLEXITY:
O(1)

-----------------------------------------------------

PATTERN:

Greedy + Cancellation (Voting Algorithm)
*/

class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int ele = 0;     // candidate
        int count = 0;   // vote count

        for (int i = 0; i < nums.size(); i++) {

            // If no candidate, pick current
            if (count == 0) {
                ele = nums[i];
                count = 1;
            }

            // Same as candidate → increase votes
            else if (nums[i] == ele) {
                count++;
            }

            // Different → cancel one vote
            else {
                count--;
            }
        }

        return ele;
    }
};