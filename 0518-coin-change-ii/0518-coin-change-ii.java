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
            dp[i][0] = 1;
        }
        for(int t =0;t<=amount;t++){
            if(t%coins[0] ==0){
                dp[0][t] = 1;
            }else{
                dp[0][t] = 0;
            }}
        for(int ind=1;ind<coins.length;ind++){
            for(int target = 1;target<=amount;target++){
                int take =0;
                if(target>=coins[ind]){
                    take = dp[ind][target-coins[ind]];
                    }
                int ntake = dp[ind-1][target];
                dp[ind][target] = take+ntake;
            }
        }
        return dp[coins.length-1][amount];
    }
}