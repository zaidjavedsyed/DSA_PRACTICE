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
    int maxdiam=0;
    public int height(TreeNode root){
        if(root==null){
            return 0;
        }
        int hleft = height(root.left);
        int hright = height(root.right);
        maxdiam = Math.max(maxdiam,hleft+hright); 
        return Math.max(hleft,hright)+1;

    }
    public int diameterOfBinaryTree(TreeNode root) {
       height(root);
       return maxdiam;
    }
}