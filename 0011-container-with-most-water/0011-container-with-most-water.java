class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int length = right - left;
            int breadth = height[left] < height[right] ? height[left] : height[right];
            max = Math.max(max, length * breadth);
            if (height[left] < height[right]) {
                left ++;
            } else {
                right --;
            }    
        }
        return max;
    }
}