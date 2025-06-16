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
    public TreeNode treemaking(int[] preorder,int prestart,int preend,int[] inorder,int instart,int inend
    ,HashMap<Integer,Integer> hp){
        if(prestart>preend || instart>inend){
            return null;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        int inroot = hp.get(root.val);
        int numleft = inroot-instart;
        root.left = treemaking(preorder,prestart+1,prestart+numleft,inorder,instart,inroot-1,hp);
        root.right = treemaking(preorder,prestart+numleft+1,preend,inorder,inroot+1,inend,hp);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hp = new HashMap<>();
        for(int i =0;i<inorder.length;i++){
            hp.put(inorder[i],i);
        }
      return  treemaking(preorder,0,preorder.length-1,inorder,0,inorder.length-1,hp);
    }
}