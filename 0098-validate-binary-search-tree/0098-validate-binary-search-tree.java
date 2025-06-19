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
    public int leftmost(TreeNode root){
        if(root.left==null){
            return root.val;
        }
        return leftmost(root.left);
    }
    public int rightmost(TreeNode root){
        if(root.right == null){
            return root.val;
        }
        return rightmost(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        if(root.left == null && root.right == null){
            return true;
        }
        if(root.left!=null && root.right!=null && root.val<root.right.val && root.val > root.left.val &&
        root.val >rightmost(root.left) && root.val< leftmost(root.right)){
            return true & isValidBST(root.left) & isValidBST(root.right);
        }
        else if(root.left==null){
            return (root.val <root.right.val) & (root.val< leftmost(root.right)) & isValidBST(root.right);
        }
        else if(root.right==null){
            return (root.val>root.left.val) & (root.val>rightmost(root.left)) & isValidBST(root.left);
        }
        else{
            return false;
        }
    }
}