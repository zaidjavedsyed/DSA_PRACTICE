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
    public boolean check(TreeNode ra,TreeNode rb){
        if(ra==null && rb==null){
            return true;
        }
        if((ra == null && rb!=null) || (ra!=null && rb==null)){
            return false;
        }
        return ra.val==rb.val && check(ra.left,rb.right) && check(ra.right,rb.left);
    }
    public boolean isSymmetric(TreeNode root) {
    return check(root.left,root.right);
    }
}