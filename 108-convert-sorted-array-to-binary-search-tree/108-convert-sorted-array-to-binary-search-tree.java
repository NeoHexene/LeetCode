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
    public TreeNode sortedArrayToBST(int[] nums) {
        return helperFunc(nums, 0, nums.length-1);
    }
    
    public TreeNode helperFunc(int[] nums, int low, int high){
        if(low > high){
            return null;
        }
        TreeNode node = new TreeNode();
        int mid = low + (high-low)/2;
        node.val = nums[mid];
        node.left = helperFunc(nums, low, mid-1);
        node.right = helperFunc(nums, mid+1, high);
        return node;

    }
}