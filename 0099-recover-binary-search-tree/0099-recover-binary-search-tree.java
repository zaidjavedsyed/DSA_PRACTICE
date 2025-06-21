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
    TreeNode prev = null;
    int count =0;
    TreeNode first =null;
    TreeNode middle = null;
    TreeNode second=null;
    public void swap(TreeNode r1,TreeNode r2){
        int temp = r1.val;
        r1.val=r2.val;
        r2.val=temp;
    }
    public void inorder(TreeNode root){
        if(root==null){
            return;
        }
        inorder(root.left);
        if(prev!=null){
            if(root.val<prev.val && count==0){
                first = prev;
                middle = root;
                count++;
            }else if(root.val<prev.val && count ==1){
                second = root;
                count++;
            }}
            prev=root;
        
        inorder(root.right);
    } 
    public void recoverTree(TreeNode root) {
        inorder(root);
        if(count ==1){
            swap(first,middle);
        }else if(count==2){
            swap(first,second);
        }
        return;
    }
}