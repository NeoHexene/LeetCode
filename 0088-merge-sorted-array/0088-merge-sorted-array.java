/*
INTUITION:
We are given two sorted arrays:
- nums1 (size m + n, with extra space at the end)
- nums2 (size n)

We need to merge nums2 into nums1 in sorted order.

-----------------------------------------------------

KEY IDEA:

Instead of merging from the front (which would overwrite values in nums1),
we merge from the BACK.

Why?
    Because nums1 has empty space at the end, so we can safely fill from right → left.

-----------------------------------------------------

BRUTE FORCE APPROACH:

- Copy nums2 into nums1
- Sort nums1

Time Complexity: O((m + n) log(m + n))  
Space Complexity: O(1)

-----------------------------------------------------

OPTIMIZED APPROACH (USED HERE):

Use three pointers:
- midx → last valid element in nums1
- nidx → last element in nums2
- right → position to fill in nums1

Compare from the back:
- Place the larger element at nums1[right]
- Move pointers accordingly

-----------------------------------------------------

IMPLEMENTED LOGIC:

1. Start from the end:
   - right = m + n - 1
   - midx = m - 1
   - nidx = n - 1

2. While nums2 still has elements:
   - Compare nums1[midx] and nums2[nidx]
   - Place the larger one at nums1[right]

3. Move pointers accordingly

Why only loop on nidx?
    Because if nums2 is done, nums1 is already correctly placed

-----------------------------------------------------

TIME COMPLEXITY:
O(m + n)

SPACE COMPLEXITY:
O(1)
*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // Pointer for placing elements from the end
        int right = m + n - 1;

        // Pointer for last valid element in nums1
        int midx = m - 1;

        // Pointer for nums2
        int nidx = n - 1;

        // Merge while nums2 still has elements
        while (nidx >= 0) {

            // If nums1 still has elements and its current value is larger
            if (midx >= 0 && nums1[midx] > nums2[nidx]) {
                nums1[right] = nums1[midx];
                midx--; // move nums1 pointer
            } else {
                nums1[right] = nums2[nidx];
                nidx--; // move nums2 pointer
            }

            // Move fill pointer
            right--;
        }
    }
}