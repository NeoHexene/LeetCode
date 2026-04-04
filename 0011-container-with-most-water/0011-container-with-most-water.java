class Solution {
    
    /*
    [1, 8, 6, 2, 5, 4, 8, 3, 7]
    area = length * breadth
    keep on moving the side whose height is less

    [1, 1]
    */

    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int length = right - left;
            int breadth = Math.min(height[right], height[left]);
            max = Math.max(max, length * breadth);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}