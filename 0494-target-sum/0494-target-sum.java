class Solution {
    public int findno(int ind,int target,int[] nums){
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
       int takep = findno(ind-1,target-nums[ind],nums);
       int taken = findno(ind-1,target+nums[ind],nums);
        return takep+taken;
    }
    public int findTargetSumWays(int[] nums, int target) {
        if(nums.length==1 && nums[0]==0){
            return 2;
        }
        return findno(nums.length-1,target,nums);
    }
}