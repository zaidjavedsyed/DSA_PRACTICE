class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m=triangle.size();
        int[][] dp = new int[m][m];
    /*    for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }*/
        for(int i=m-1;i>=0;i--){
            for(int j=i;j>=0;j--){
                if(i==m-1){
                    dp[i][j] =triangle.get(i).get(j); 
                }
                else{
                    int c = triangle.get(i).get(j)+dp[i+1][j];
                    int r = triangle.get(i).get(j)+dp[i+1][j+1];
                    dp[i][j] = Math.min(c,r);
                }
            }
        }
      return dp[0][0];
    }
}