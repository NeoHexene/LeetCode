class Solution {
    
    /*
    INTUITION:

    We want to find two lines such that they form a container
    with the maximum water.

    Area = width * height
         = (right - left) * min(height[left], height[right])

    Key idea:
    - Start with the widest container (left at 0, right at end)
    - Try to improve the area by moving pointers

    Important observation:
    - The height of the container is limited by the smaller height
    - So to potentially get a bigger area, we must move the pointer
      pointing to the smaller height

    Why?
    - Moving the taller line won’t help, because height is still limited
      by the shorter one
    - Only moving the shorter one might find a taller line

    So:
    👉 Always move the pointer with smaller height
    */

    public int maxArea(int[] height) {

        // Two pointers: start from both ends
        int left = 0;
        int right = height.length - 1;

        // Store maximum area found
        int max = 0;

        while (left < right) {

            // Width between two lines
            int length = right - left;

            // Height is limited by the smaller line
            int breadth = Math.min(height[left], height[right]);

            // Update maximum area
            max = Math.max(max, length * breadth);

            // Move the pointer with smaller height
            if (height[left] > height[right]) {
                // Right is smaller → move right inward
                right--;
            } else {
                // Left is smaller (or equal) → move left inward
                left++;
            }
        }

        return max;
    }
}