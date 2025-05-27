class Solution {
    public int lessthanequalk(int[] nums,int k){
        if(k<0){
            return 0;
        }
        int r=0;
        int l=0;
        int ans=0;
        int codd=0;
        while(r<nums.length){
            if(nums[r]%2!=0){
                codd++;
            }
            while(codd>k){
                if(nums[l]%2!=0){
                    codd--;
                }
                l++;
            }
            ans = ans+r-l+1;
            r++;
        }
        return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return lessthanequalk(nums,k)-lessthanequalk(nums,k-1);
    }
}