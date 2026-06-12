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

    private List<String> binaries;

    private void dfs(StringBuilder sb, TreeNode root, int idx) {
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            binaries.add(sb.toString());
            sb.deleteCharAt(idx);
            return;

        }
        sb.append(root.val);
        if (root.left != null) {
            dfs(sb, root.left, idx + 1);
        }
        if (root.right != null) {
            dfs(sb, root.right, idx + 1);
        }
        sb.deleteCharAt(idx);
    }

    private int binaryToDecimal(String s) {
        int decimal = 0;
        int pow = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                decimal += pow;
            }

            pow *= 2;

        }

        return decimal;
    }

    public int sumRootToLeaf(TreeNode root) {

        binaries = new ArrayList<>();
        dfs(new StringBuilder(), root, 0);

        int res = 0;

        for (String s : binaries) {
            res += binaryToDecimal(s);
        }

        return res;

    }
}