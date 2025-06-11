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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q =new LinkedList<>();
        q.add(root);
        List<List<Integer>> fans = new ArrayList<>();
        if(root == null){
            return fans;
        }
        boolean flag = true;
        while(!q.isEmpty()){
            int size = q.size();
            Deque<Integer> dq = new LinkedList<>();
            for(int i=0;i<size;i++){
                TreeNode curr =q.poll();
                if(flag == true){
                    dq.addLast(curr.val);
                }else{
                    dq.addFirst(curr.val);
                }
                if(curr.left!=null){
                    q.add(curr.left);}
                    
                if(curr.right!=null){
                    q.add(curr.right);}
                }
                

        
        flag=!flag;
        fans.add(new ArrayList<>(dq));
    }
    return fans;
}}