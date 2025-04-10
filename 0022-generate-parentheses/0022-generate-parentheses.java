class Solution {
    public void pat(int open,int close,String s,int n,List<String> ans){
        if(open==n && close == n){
            ans.add(s);
            return;
        }
        if(open<n){
            pat(open+1,close,s+'(',n,ans);
        }
        if(close<open){
            pat(open,close+1,s+')',n,ans);
        }
    }
    public List<String> generateParenthesis(int n){
        
        List<String> ans= new ArrayList<>();
        pat(0,0,"",n,ans);
        return ans;
    }
}