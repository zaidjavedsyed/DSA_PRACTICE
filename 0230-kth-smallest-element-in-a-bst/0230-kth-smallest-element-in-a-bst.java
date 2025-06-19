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
    public void traverse(TreeNode root,Queue<Integer> pq){
        if(root==null){
            return;
        }
        pq.add(root.val);
        traverse(root.left,pq);
        traverse(root.right,pq);

    }
    public int kthSmallest(TreeNode root, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        traverse(root,pq);
        while(k>1){
            pq.poll();
            k--;
        }
        return pq.poll();
    }
}