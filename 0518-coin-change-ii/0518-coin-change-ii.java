class Solution {
    public int change(int amount, int[] coins) {
      /* tabulation 
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
    */
    int[] curr = new int[amount+1];
    int[] prev = new int[amount+1];
        curr[0] = 1;
        for(int t =0;t<=amount;t++){
            if(t%coins[0] ==0){
                prev[t] = 1;
            }else{
                prev[t] = 0;
            }}
        for(int ind=1;ind<coins.length;ind++){
            for(int target = 1;target<=amount;target++){
                int take =0;
                if(target>=coins[ind]){
                    take = curr[target-coins[ind]];
                    }
                int ntake = prev[target];
                curr[target] = take+ntake;
            }
            prev = curr.clone();
        }
        return prev[amount];
    }
}