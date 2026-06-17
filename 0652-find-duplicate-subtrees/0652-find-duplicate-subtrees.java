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

    private String helper(TreeNode root, Map<String, Integer> map, List<TreeNode> res) {
        if (root == null) {
            return "#";
        }
        String left = helper(root.left, map, res);
        String right = helper(root.right, map, res);
        String preOrder = root.val + ',' + left + ',' + right;

        if (map.getOrDefault(preOrder, 0) == 1) {
            res.add(root);
        }

        map.put(preOrder, map.getOrDefault(preOrder, 0) + 1);
        return preOrder;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        String x = helper(root, map, res);
        return res;
    }
}