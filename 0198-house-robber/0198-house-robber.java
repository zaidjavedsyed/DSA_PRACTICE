class Solution {
    public int find(int i,int[] dp,int[] nums){
        if(i<0){
            return 0;
        }
        if(i==0 || i==1){
            return nums[i];
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int left = find(i-2,dp,nums)+nums[i];
        int right = find(i-3,dp,nums)+nums[i];
        int maxResult = Math.max(left,right);
        dp[i] = maxResult;
        return maxResult;
        
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[nums.length+1];
        for(int i=0;i<n;i++){
            dp[i]=-1;
        }
        return Math.max(find(n-1,dp,nums),find(n-2,dp,nums));
    }
}