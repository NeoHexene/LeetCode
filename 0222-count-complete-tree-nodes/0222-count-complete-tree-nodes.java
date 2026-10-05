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

    private int findLeftHeight(TreeNode root) {
        int count = 0;
        while (root != null) {
            root = root.left;
            count++;
        }
        return count;
    }

    private int findRightHeight(TreeNode root) {
        int count = 0;
        while (root != null) {
            root = root.right;
            count++;
        }
        return count;
    }

    private int dfs(TreeNode root) {
        
        if (root == null) {
            return 0;
        }

        int lh = findLeftHeight(root);
        int rh = findRightHeight(root);

        if (lh == rh) {
            return (int) Math.pow(2, lh) - 1;
        }

        return 1 + dfs(root.left) + dfs(root.right);
    }

    public int countNodes(TreeNode root) {
        return dfs(root);
    }
}