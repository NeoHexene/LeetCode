/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums);
    }

    private TreeNode dfs (int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int idx = maxIndex(nums);
        TreeNode node = new TreeNode(nums[idx]);
        node.left = dfs(Arrays.copyOfRange(nums, 0, idx)); // left subarray
        node.right = dfs(Arrays.copyOfRange(nums, idx + 1, nums.length)); // right subarray
        return node;
    }

    private int maxIndex (int[] nums) {
        int start = 0, end = nums.length - 1;
        while (start < end) {
            if (nums[start] > nums[end]) {
                end -= 1;
            } else {
                start += 1;
            }
        }
        return nums[start] > nums[end] ? start : end;
    }
}