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

    public List<List<String>> printTree(TreeNode root) {
        int r = getHeight(root);
        int c = (int) Math.pow(2, r) - 1;
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            res.add(new ArrayList<>());
            for (int j = 0; j < c; j++) {
                res.get(i).add("");
            }
        }
        dfs(root, 0, 0, c - 1, res);
        return res;
    }

    private void dfs(TreeNode node, int row, int start, int end, List<List<String>> res) {
        if (node == null) {
            return;
        }
        int idx = start + (end - start) / 2;
        res.get(row).set(idx, String.valueOf(node.val));
        dfs(node.left, row + 1, start, idx - 1, res);
        dfs(node.right, row + 1, idx + 1, end, res);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}