class Solution {
    public int longestOnes(int[] nums, int k) {
        int left =0;
        int length =0;
        int n = nums.length;
        int tk = k;
        for(int right =0;right<n;right++){
            while(nums[right]==0 && tk==0){
                if(nums[left]==0){
                    tk++;
                }
                left++;
            }
            if(nums[right]==0){
                tk--;
            }
            length = Math.max(length,right-left+1);
            
        }
        return length;
    }
}