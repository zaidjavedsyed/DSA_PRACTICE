class Solution {
     public int find(int i,int j,int[][] dp,int[][] obstacle){
        if(i==0 && j==0){
            return 1;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int up=0;
        if(i>0 && obstacle[i-1][j] !=1){
            up = find(i-1,j,dp,obstacle);
        }
        int left = 0;
        if(j>0 && obstacle[i][j-1]!=1){
            left = find(i,j-1,dp,obstacle);
        }
        int ways = up+left;
        dp[i][j]=ways;
        return ways;
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m= obstacleGrid.length;
        int n= obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1]==1){
            return 0;
        }
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return find(m-1,n-1,dp,obstacleGrid);

    }
}