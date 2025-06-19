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
    public TreeNode rightmost(TreeNode root){
        if(root.right==null){
            return root;
        }
        return rightmost(root.right);
    }
    public TreeNode helper(TreeNode root){
        if(root.left == null){
            return root.right;
        }
        if(root.right == null){
            return root.left;
        }
        TreeNode right = root.right;
        root.right = null;
        TreeNode leftgreatest = rightmost(root.left);
        leftgreatest.right=right;
        return root.left;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode dummy  = root;
        if(root==null){
            return root;
        }
        if(root.left ==null && root.right == null ){
            if(root.val == key){
                return null;
            }else{
                return root;
            }
        }
        while(root!=null){
            if(root.val>key){
                if(root.left!=null && root.left.val ==key){
                    root.left = helper(root.left);
                    break;
                }else{
                    root = root.left;
                }
            }else if(root.val<key){
                if(root.right !=null && root.right.val == key){
                    root.right = helper(root.right);
                    break;
                }else{
                    root = root.right;
                }
            }else{
               return helper(root);
            }
    }
    return dummy;
}}