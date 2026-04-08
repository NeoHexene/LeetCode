/*
INTUITION:

We need to traverse the matrix in a spiral order:
→ left to right
↓ top to bottom
← right to left
↑ bottom to top

We keep shrinking the boundaries after each direction.

We maintain 4 pointers:
- top    → starting row
- bottom → ending row
- left   → starting column
- right  → ending column

At each step, we traverse one side and then move the boundary inward.

-----------------------------------------------------

BRUTE FORCE APPROACH:

- Keep a visited matrix
- Move in spiral direction using direction array
- Mark visited cells

Time Complexity: O(m * n)
Space Complexity: O(m * n)

-----------------------------------------------------

OPTIMIZED APPROACH (USED HERE):

Use boundary pointers (no extra space).

Steps:
1. Traverse top row → move top down
2. Traverse right column → move right left
3. Traverse bottom row → move bottom up
4. Traverse left column → move left right

Repeat until boundaries cross.

-----------------------------------------------------

IMPORTANT EDGE CASE:

After updating top and right, we must check:
    whether boundaries are still valid

Otherwise we may traverse same row/column twice.

-----------------------------------------------------

TIME COMPLEXITY:
O(m * n)

SPACE COMPLEXITY:
O(1) (excluding output list)
*/

class Solution {
    public List<Integer> spiralOrder(int[][] grid) {

        int top = 0;
        int bottom = grid.length - 1;
        int left = 0;
        int right = grid[0].length - 1;

        List<Integer> res = new ArrayList<>();

        // Continue until boundaries overlap
        while (top <= bottom && left <= right) {

            // 1. Traverse from left → right (top row)
            for (int i = left; i <= right; i++) {
                res.add(grid[top][i]);
            }
            top++; // move top boundary down

            // 2. Traverse from top → bottom (right column)
            for (int i = top; i <= bottom; i++) {
                res.add(grid[i][right]);
            }
            right--; // move right boundary left

            /*
             * IMPORTANT CHECK:
             * After shrinking top and right,
             * we must ensure boundaries are still valid.
             * Otherwise, we might re-traverse the same row/column.
             */
            if (!(left <= right && top <= bottom)) {
                break;
            }

            // 3. Traverse from right → left (bottom row)
            for (int i = right; i >= left; i--) {
                res.add(grid[bottom][i]);
            }
            bottom--; // move bottom boundary up

            // 4. Traverse from bottom → top (left column)
            for (int i = bottom; i >= top; i--) {
                res.add(grid[i][left]);
            }
            left++; // move left boundary right
        }

        return res;
    }
}