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

    private void dfs(StringBuilder sb, TreeNode root) {
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            System.out.println("String: " + sb.toString());
            binaries.add(sb.toString());
            sb.deleteCharAt(sb.length() - 1);
            return;

        }
        sb.append(root.val);
        if (root.left != null) {
            dfs(sb, root.left);
        }
        if (root.right != null) {
            dfs(sb, root.right);
        }
        sb.deleteCharAt(sb.length() - 1);
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
        dfs(new StringBuilder(), root);

        int res = 0;

        for (String s : binaries) {
            res += binaryToDecimal(s);
        }

        return res;

    }
}