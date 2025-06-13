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
    public void parbfs(HashMap<TreeNode,TreeNode> par,TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(curr.left!=null){
                    par.put(curr.left,curr);
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    par.put(curr.right,curr);
                    q.add(curr.right);
                }
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> par = new HashMap<>();
        parbfs(par,root);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        HashSet<TreeNode> visited = new HashSet<>();
        visited.add(target);
        int currlevel = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(currlevel==k){
                break;
            }
            currlevel++;
            for(int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if(par.get(curr)!=null && !visited.contains(par.get(curr))){
                    q.add(par.get(curr));
                    visited.add(par.get(curr));
                }
                if(curr.left!=null && !visited.contains(curr.left)){
                    q.add(curr.left);
                    visited.add(curr.left);
                }
                if(curr.right!=null && !visited.contains(curr.right)){
                    q.add(curr.right);
                    visited.add(curr.right);
                }
            }
                    }
            List<Integer> ans = new ArrayList<>();
            while(!q.isEmpty()){
                ans.add(q.poll().val);
            }
        return ans;
    }
}