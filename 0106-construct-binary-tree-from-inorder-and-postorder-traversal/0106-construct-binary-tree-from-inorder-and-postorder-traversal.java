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
    public TreeNode treemaking(int[] postorder,int postart,int poend,int[] inorder,int instart,int inend,
    HashMap<Integer,Integer> hp){
        if(postart<poend || instart>inend){
            return null;
        }
        TreeNode root = new TreeNode(postorder[postart]);
        int inroot = hp.get(root.val);
        int numright = inend-inroot;
        root.right = treemaking(postorder,postart-1,postart-numright,inorder,inroot+1,inend,hp);
        root.left = treemaking(postorder,postart-numright-1,poend,inorder,instart,inroot-1,hp);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer> hp = new  HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hp.put(inorder[i],i);
        }
        return treemaking(postorder,postorder.length-1,0,inorder,0,inorder.length-1,hp);
    }
}