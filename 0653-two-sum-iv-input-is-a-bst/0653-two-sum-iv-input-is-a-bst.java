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
    public void inordertr(TreeNode root,List<Integer> inorder){
        if(root==null){
            return;
        }
        inordertr(root.left,inorder);
        inorder.add(root.val);
        inordertr(root.right,inorder);
    }
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        inordertr(root,inorder);
        int p = 0;
        int q= inorder.size()-1;
        while(p<q){
            int sum = inorder.get(p)+inorder.get(q);
            if(sum<k){
                p++;
            }else if(sum==k){
                return true;
            }else{
                q--;
            }
        }
        return false;
    }
}