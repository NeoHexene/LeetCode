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

    private int dfs(TreeNode root) {
        
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        if (right == -1 || left == -1 || Math.abs(right - left) > 1) {
            return -1;
        }
        
        return Math.max(right, left) + 1;
        
    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }
}