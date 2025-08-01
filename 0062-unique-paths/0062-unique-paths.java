class Solution {
    public int find(int i,int j,int[][] dp){
        if(i==0 && j==0){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int up=0;
        if(i>0){
            up = find(i-1,j,dp);
        }
        int left = 0;
        if(j>0){
            left = find(i,j-1,dp);
        }
        int ways = up+left;
        dp[i][j]=ways;
        return ways;
    }
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return find(m-1,n-1,dp);
    }
}