class Solution {
    public static int lessthanequalnice(int[] nums,int k){
        int r=0;
        int l=0;
        int c=0;
        int ans=0;
        while(r<nums.length){
            if(nums[r]%2!=0){
                c++;
            }
            while(c>k && l<nums.length){
                if(nums[l]%2!=0){
                    c--;
                }
                l++;
            }
            ans = ans + r-l+1;
            r++;
        }
        return ans;
    }
    public int numberOfSubarrays(int[] nums, int k) {
      int g= lessthanequalnice(nums,k);
      int l= lessthanequalnice(nums,k-1);
       return g-l;
    }
}