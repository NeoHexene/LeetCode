/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            
            TreeNode node = q.poll();

            if (node == null) {
                sb.append(",#");
            } else {

                q.offer(node.left);
                q.offer(node.right);

                if (sb.isEmpty()) {
                    sb.append(node.val);
                } else {
                    sb.append("," + node.val);
                }
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data.isEmpty()) {
            return null;
        }

        String[] values = data.split(",");
        
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        for (int i = 1; i < values.length; i += 2) {
            
            TreeNode node = q.poll();

            if (("#").equals(values[i])) {
                node.left = null;
            } else {
                node.left = new TreeNode(Integer.parseInt(values[i]));
                q.offer(node.left);
            }

            if (("#").equals(values[i + 1])) {
                node.right = null;
            } else {
                node.right = new TreeNode(Integer.parseInt(values[i + 1]));
                q.offer(node.right);
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));