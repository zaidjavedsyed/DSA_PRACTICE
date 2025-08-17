class Solution {
    // We are going to solve this by shifting of index so if i=n it means n-1or i==0 then i =-1 this is to solve base case problem for tabulation 
    public int find(int i,int j,String text1,String text2,int[][] dp){
        if(i==0 || j==0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int take = 0;
        if(text1.charAt(i-1)==text2.charAt(j-1)){
            dp[i][j]=find(i-1,j-1,text1,text2,dp)+1;
            return find(i-1,j-1,text1,text2,dp)+1;
        }
        int iback=find(i-1,j,text1,text2,dp);
        int jback = find(i,j-1,text1,text2,dp);
        int max1= Math.max(iback,jback);
        dp[i][j] = max1;
        return max1;

    }
    public int longestCommonSubsequence(String text1, String text2) {
        
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i=0;i<=text1.length();i++){
            for(int j=0;j<=text2.length();j++){
                dp[i][j]=-1;
            }
        }
        return find(text1.length(),text2.length(),text1,text2,dp);
        
        //tabulation
        


    }
}