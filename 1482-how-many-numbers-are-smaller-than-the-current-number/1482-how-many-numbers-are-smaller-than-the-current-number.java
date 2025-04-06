class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            int c=0;
            int j=0;
            while(j<n){
                if(nums[j]<nums[i]){
                    c++;
                }
                j++;
            }
            ans[i]=c;
        }
        return ans;
    }
}