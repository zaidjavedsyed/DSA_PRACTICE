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
                    return Integer.MAX_VALUE;
                }
            }else{
                return Integer.MAX_VALUE;
            }
        }
        if(dp[ind][target]!=-5){
            return dp[ind][target];
        }
        int take = Integer.MAX_VALUE;
        if(arr[ind]<=target){
            take = find(ind,target-arr[ind],arr,dp);
        }
        if(take!=Integer.MAX_VALUE){
            take+=1;
        }
        int ntake = find(ind-1,target,arr,dp);
        dp[ind][target] = Math.min(take,ntake);
        return Math.min(take,ntake);
        }
    

    public int coinChange(int[] coins, int amount) {
    
    int[][] dp= new int[coins.length][amount+1];
    for(int i=0;i<coins.length;i++){
        for(int j=0;j<=amount;j++){
            dp[i][j] = -5;
        }
    }
  int ans= find(coins.length-1,amount,coins,dp);
    if(ans == Integer.MAX_VALUE){
        return -1;
    }else{
        return ans;
    }

    }}