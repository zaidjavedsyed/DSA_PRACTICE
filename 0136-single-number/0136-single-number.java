class Solution {
    public int singleNumber(int[] nums) {
        int i=0;
        int j=1;
        int n=nums.length;
        while(i<n){
            j=0;
            while(j<n){
                if(i==j){
                    j++;
                    continue;
                }
                if(nums[i]==nums[j]){
                    break;
                }
             
                j++;
            }
            if(j>=n){
                    return nums[i];
                }
            i++;
        }
        return 0;
    }
}