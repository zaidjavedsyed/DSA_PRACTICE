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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            boolean left = (root.val>= p.val | root.val>=q.val);
            boolean right = (root.val<=p.val | root.val<=q.val);
            if(left && right){
                return root;
            }
            else if(left){
                root= root.left;
            }
            else if(right){
                root=root.right;
            }
        }
        return root;
    }
}