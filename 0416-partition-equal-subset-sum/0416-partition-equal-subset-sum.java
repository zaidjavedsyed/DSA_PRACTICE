class Solution {
     static boolean subsetsum(int i,int target,int[] arr,int[][] dp){
        if(target==0){
            return true;
        }
        if(i ==0){
            return target==arr[i];
        }
        if(dp[i][target]!=-1){
            if(dp[i][target]==1){
                return true;}
            else{
                return false;
            }
        }
        boolean take = false;
        if(target>= arr[i]){
            take = subsetsum(i -1,target-arr[i],arr,dp);
        }
        boolean ntake = subsetsum(i-1,target,arr,dp);
         if(take || ntake){
             dp[i][target] = 1;
         }else{
             dp[i][target] =0;
         }
        return take || ntake;
    }
    public boolean canPartition(int[] nums) {
        
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        int[][] dp = new int[nums.length][sum];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<sum;j++){
                dp[i][j] = -1;
            }
        }
        return subsetsum(nums.length-1,sum/2,nums,dp);
    }
}