class Solution {
    public int find(int ind,int target,int[] arr,int[][] dp){
        if(target==0){
            return 0;
        }
        if(ind ==0){
            if(arr[0]<=target){
                if(target%arr[0]==0){
                    return target/arr[0];
                }else{
                    return -1;
                }
            }else{
                return -1;
            }
        }
        if(dp[ind][target]!=-5){
            return dp[ind][target];
        }
        int take = -1;
        if(arr[ind]<=target){
            take = find(ind,target-arr[ind],arr,dp);
        }
        int ntake = find(ind-1,target,arr,dp);
        if(take ==-1 && ntake ==-1){
            dp[ind][target] = -1;
            return -1;
        }else if(take ==-1 && ntake!=-1){
            dp[ind][target] = ntake;
            return ntake;
        }else if(take !=-1 && ntake == -1 ){
            dp[ind][target] = take+1;
            return take+1;
        }
        else{
            dp[ind][target] = Math.min(take+1,ntake);
            return Math.min(take+1,ntake);
        }
    }

    public int coinChange(int[] coins, int amount) {
    int[][] dp= new int[coins.length][amount+1];
    for(int i=0;i<coins.length;i++){
        for(int j=0;j<=amount;j++){
            dp[i][j] = -5;
        }
    }
  return find(coins.length-1,amount,coins,dp);

    }
}