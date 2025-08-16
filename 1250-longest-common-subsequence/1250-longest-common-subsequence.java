class Solution {
    public int find(int i,int j,String text1,String text2,int[][] dp){
        if(i==0){
            for(int t=j;t>=0;t--){
                if(text1.charAt(i)==text2.charAt(t)){
                    return 1;
                }
            }
            return 0;
        }
        if(j==0){
            for(int t=i;t>=0;t--){
                if(text1.charAt(t)==text2.charAt(j)){
                    return 1;
                }
            }
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int take = 0;
        if(text1.charAt(i)==text2.charAt(j)){
            take = find(i-1,j-1,text1,text2,dp)+1;
        }
        int iback=find(i-1,j,text1,text2,dp);
        int jback = find(i,j-1,text1,text2,dp);
        int max1= Math.max(iback,jback);
        dp[i][j] = Math.max(take,max1);
        return Math.max(take,max1);

    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int i=0;i<text1.length();i++){
            for(int j=0;j<text2.length();j++){
                dp[i][j]=-1;
            }
        }
        return find(text1.length()-1,text2.length()-1,text1,text2,dp);
    }
}