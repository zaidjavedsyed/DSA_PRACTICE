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
class Pair{
    int index;
    TreeNode node;
    Pair(TreeNode node,int index){
        this.index = index;
        this.node =node;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int maxwidth = Integer.MIN_VALUE;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int last=0;
            int first=0;
            int size = q.size();
            int min = q.peek().index;
            for(int i=0;i<size;i++){
                Pair curr = q.poll();
                int ind = curr.index-min;
                if(curr.node.left!=null){
                    q.add(new Pair(curr.node.left,2*ind+1));
                }
                if(curr.node.right!=null){
                    q.add(new Pair(curr.node.right,2*ind+2));
                }
                if(i==0){
                    first = ind;
                }
                if(i==size-1){
                    last = ind;
                }
            }
            maxwidth = Math.max(last-first+1,maxwidth);

        }
        return maxwidth;

    }
}