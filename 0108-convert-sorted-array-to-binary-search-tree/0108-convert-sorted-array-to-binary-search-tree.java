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

    private TreeNode buildTree(int[] nums, int low, int high) {

        int mid = low + (high - low) / 2;
        if (low > high) {
            return null;
        }

        TreeNode newNode = new TreeNode(nums[mid]);

        newNode.left = buildTree(nums, low, mid - 1);
        newNode.right = buildTree(nums, mid + 1, high);

        return newNode;
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        return buildTree(nums, 0, nums.length - 1);
    }
}