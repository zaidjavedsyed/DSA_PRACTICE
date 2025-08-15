class Solution {
public int find(int target,int[] nums){
        int dp[][] = new int[nums.length][target+1];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<=target;j++){
                dp[i][j] = 0;
            }
        }
        
        if(nums[0]==0){
            dp[0][0] =2;
        }else{
            dp[0][0] =1;
        }
        if(nums[0]!=0 &&target>=nums[0]){
        dp[0][nums[0]]=1;}
        for(int i=1;i<nums.length;i++){
            for(int k=0;k<=target;k++){
                int take =0;
                if(nums[i]<=k){
                    take = dp[i-1][k-nums[i]];
                }
                int ntake = dp[i-1][k];
                dp[i][k] = take+ntake;
            }
        }
        return dp[nums.length-1][target];
         }
    int countPartitions(int[] arr, int d) {
        // code here
        int sum =0;
        for(int i=0;i<arr.length;i++){
           sum+= arr[i];
        }
        if(d>sum || (sum-d)%2!=0){
            return 0;
        }
        return find((sum-d)/2,arr);
    }



    public int findno(int ind,int target,int[] nums,int[][] dp){
        if(ind==0){
            if(Math.abs(nums[ind])==Math.abs(target)){
                if(nums[ind]==0){
                    return 2;
                }
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[ind][target]!=-1){
            return dp[ind][target];
        }
       int takep = findno(ind-1,target-nums[ind],nums,dp);
       int taken = findno(ind-1,target+nums[ind],nums,dp);
        dp[ind][target] = takep+taken;
        return takep+taken;
    }
    public int findTargetSumWays(int[] nums, int target) {
    return countPartitions(nums,target);
    
      /*  int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int dp[][] = new int[nums.length][target+sum+1];
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<=target+sum;j++){
                dp[i][j] = -1;
            }
        }
        return findno(nums.length-1,target,nums,dp);*/
    }
}