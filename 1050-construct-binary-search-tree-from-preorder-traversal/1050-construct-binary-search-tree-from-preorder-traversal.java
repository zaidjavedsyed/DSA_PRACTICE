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
    public TreeNode buildtree(int[] preorder,int prestart,int preEnd){
        if(prestart>preEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        int j = prestart+1;
        int numleft =0;
        while(j<=preEnd && root.val>preorder[j]){
            numleft++;
            j++;
        }
        root.left = buildtree(preorder,prestart+1,prestart+numleft);
        root.right = buildtree(preorder,prestart+numleft+1,preEnd);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildtree(preorder,0,preorder.length-1);
    }
}