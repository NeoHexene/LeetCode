/*
INTUITION:

We need to sort an array containing only 0s, 1s, and 2s.

Brute force:
- Sort the array → O(n log n)

Better:
- Count 0s, 1s, 2s → overwrite → O(n)

Optimal:
    Use Dutch National Flag Algorithm (one-pass, in-place)

-----------------------------------------------------

CORE IDEA:

Maintain 3 regions:

[0 ... low-1]   → all 0s
[low ... mid-1] → all 1s
[mid ... high]  → unsorted
[high+1 ... n-1]→ all 2s

We process the "unsorted" region using `mid`.

-----------------------------------------------------

HOW IT WORKS:

Case 1: nums[mid] == 0
→ Swap with nums[low]
→ Expand 0s region
→ move both low and mid

Case 2: nums[mid] == 1
→ Already in correct region
→ just move mid

Case 3: nums[mid] == 2
→ Swap with nums[high]
→ shrink 2s region
→ DO NOT move mid (because swapped value needs processing)

-----------------------------------------------------

IMPORTANT DETAIL:

When swapping with high:
    we do NOT increment mid because the new element at mid is unprocessed

-----------------------------------------------------

EXAMPLE:

nums = [2,0,2,1,1,0]

Step-by-step, we push:
- 0s to the left
- 2s to the right
- 1s naturally stay in the middle

-----------------------------------------------------

TIME COMPLEXITY:
O(n) → single pass

SPACE COMPLEXITY:
O(1) → in-place

-----------------------------------------------------

PATTERN:

Three pointers / Dutch National Flag
*/

class Solution {
public:
    void sortColors(vector<int>& nums) {

        int low = 0;                 // boundary for 0s
        int mid = 0;                 // current element
        int high = nums.size() - 1;  // boundary for 2s

        while (mid <= high) {

            if (nums[mid] == 0) {
                // place 0 in correct region
                swap(nums[low], nums[mid]);
                low++;
                mid++;
            }

            else if (nums[mid] == 2) {
                // place 2 in correct region
                swap(nums[mid], nums[high]);
                high--;
                // do NOT increment mid
            }

            else {
                // nums[mid] == 1
                mid++;
            }
        }
    }
};