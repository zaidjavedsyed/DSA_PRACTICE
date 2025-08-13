class Solution {
      static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        boolean[] prev = new boolean[sum+1];
        prev[0] = true;
        if(arr[0]<=sum){
        prev[arr[0]] = true;
}        for(int i=1;i<n;i++){
           boolean[] curr = new boolean[sum + 1];
            curr[0] = true;
            for(int target = 1;target<=sum;target++){
                
                boolean take = false;
                if(target>= arr[i]){
                    take = prev[target-arr[i]];
                }
                boolean ntake = prev[target];
                curr[target]= take || ntake;
       
                    }
                    prev = curr;
                }
        return prev[sum];
        
    }
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
        int[][] dp = new int[nums.length][sum/2+1];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<sum/2+1;j++){
                dp[i][j] = -1;
            }
        }
        return isSubsetSum(nums,sum/2);
    }
}