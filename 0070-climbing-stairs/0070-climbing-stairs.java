class Solution {
    public int find(int i,int dp[]){
        if(i==1 || i==0){
            return 1;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int left = find(i-1,dp);
        int right = find(i-2,dp);
        dp[i]=left+right;
        return left+right;
    
    }
    public int climbStairs(int n) {
    int dp[] = new int[n+1];
    for(int i=0;i<=n;i++){
        dp[i]=-1;
    }
    return find(n,dp);
    }
}