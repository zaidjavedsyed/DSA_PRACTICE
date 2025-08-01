class Solution {
    public int find(int i,int j,int[][] grid,int[][] dp){
        if(i==0 && j==0){
            return grid[0][0];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int up=Integer.MAX_VALUE;
        if(i>0){
            up = grid[i][j]+find(i-1,j,grid,dp);
        }
        int left = Integer.MAX_VALUE;
        if(j>0){
            left = grid[i][j]+find(i,j-1,grid,dp);
        }
        int cost = Math.min(up,left);
        dp[i][j] = cost;
        return cost;
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n= grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return find(m-1,n-1,grid,dp);
    }
}