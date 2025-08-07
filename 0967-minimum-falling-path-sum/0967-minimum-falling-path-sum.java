class Solution {
    public int minFallingPathSum(int[][] matrix) {
       int m = matrix.length;
       int dp[][] = new int[m][m];
       for(int i=m-1;i>=0;i--){
        for(int j=m-1;j>=0;j--){
            if(i==m-1){
                dp[i][j] = matrix[i][j];
            }else{
                int d = matrix[i][j]+dp[i+1][j];
                int r = Integer.MAX_VALUE;
                int l = Integer.MAX_VALUE;
                if(j<m-1){
                    r = matrix[i][j]+dp[i+1][j+1];
                }
                if(j>0){
                    l=matrix[i][j]+dp[i+1][j-1];
                }
                int min1 = Math.min(l,d);
                dp[i][j] = Math.min(min1,r);
        }
        }
       }

       int min = dp[0][0];
       for(int i=0;i<dp.length;i++){
        min = Math.min(min,dp[0][i]);
       }
       return min;
    }
}