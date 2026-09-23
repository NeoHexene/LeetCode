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

    // Self sufficient function
    // // 0th element stores the max height, 1st element stores the max diameter found so far
    // private int[] dfs(TreeNode root) {

    //     if (root == null) {
    //         return new int[]{0, 0};
    //     }

    //     int left[] = dfs(root.left);
    //     int right[] = dfs(root.right);

    //     return new int[]{Math.max(left[0], right[0]) + 1, Math.max(left[0] + right[0], Math.max(left[1], right[1]))};

    // }

    private int max;

    private int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        max = Math.max(left + right, max);

        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {

        // Self sufficient method
        // return dfs(root)[1];

        // More cleaner approach
        dfs(root);
        return max;
    }
}