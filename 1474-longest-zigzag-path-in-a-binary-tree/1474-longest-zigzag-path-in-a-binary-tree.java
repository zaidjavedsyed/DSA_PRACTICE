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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int ans = 0;
    
    public int longestZigZag(TreeNode root) {
        dfs(root);
        return ans;
    }
    
    // Returns an array [leftLen, rightLen]:
    // leftLen  = longest ZigZag path starting by going to the left child
    // rightLen = longest ZigZag path starting by going to the right child
    private int[] dfs(TreeNode node) {
        if (node == null) {
            // Use -1 so that at a leaf, 1 + (-1) = 0 edges
            return new int[]{-1, -1};
        }
        int[] L = dfs(node.left);
        int[] R = dfs(node.right);
        // If we go left first, next move must be from the left child to its right
        int leftLen  = 1 + L[1];
        // If we go right first, next move must be from the right child to its left
        int rightLen = 1 + R[0];
        // Update global maximum
        ans = Math.max(ans, Math.max(leftLen, rightLen));
        return new int[]{leftLen, rightLen};
    }
}
