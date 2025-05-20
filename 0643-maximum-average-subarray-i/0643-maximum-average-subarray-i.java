class Solution {
    public double findMaxAverage(int[] nums, int k) {
         int sum = 0;
         for(int i=0;i<k;i++){
            sum+=nums[i];
         }
         int n = nums.length;
         int nextsum=sum;
         for(int i=k;i<n;i++){
            nextsum+=nums[i];
            nextsum-=nums[i-k];
            sum = Math.max(nextsum,sum);
         }
         double ans = (double)sum/k;
         return ans;
    }
}