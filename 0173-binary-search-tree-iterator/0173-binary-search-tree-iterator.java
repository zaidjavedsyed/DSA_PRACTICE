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
class BSTIterator {
    Stack<TreeNode> st = new Stack<>();
    public void addAllLeft(TreeNode root){
        if(root==null){
            return;
        }
        st.add(root);
        addAllLeft(root.left);
    }
    public BSTIterator(TreeNode root) {
        st.add(root);
        addAllLeft(root.left);
    }
    
    public int next() {
       TreeNode s=st.pop();
       if(s.right!=null){
        addAllLeft(s.right);
       }
       return s.val;
    }
    
    public boolean hasNext() {
        if(!st.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */