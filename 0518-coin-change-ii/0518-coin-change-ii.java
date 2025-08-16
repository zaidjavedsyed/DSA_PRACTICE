class Solution {
    public int find(int ind,int target,int[] arr,int[][] dp){
        if(target==0){
            return 1;
        }
        if(ind==0){
            if(arr[0]<=target){
                if(target%arr[0]==0){
                    return 1;
                }else{
                    return 0;
                }
            }else{
                return 0;
            }
        }
        if(dp[ind][target]!=-1){
            return dp[ind][target];
        }
        int take =0;
        if(target>=arr[ind]){
            take = find(ind,target-arr[ind],arr,dp);
        }
        int ntake = find(ind-1,target,arr,dp);
        dp[ind][target] = take+ntake;
        return take+ntake;
    }
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i=0;i<coins.length;i++){
            for(int j=0;j<amount+1;j++){
                dp[i][j] = -1;
            }
        }
        return find(coins.length-1,amount,coins,dp);
    }
}