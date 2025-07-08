class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int val = nums[i];
            if(val<0){
                int r = val*-1;
                if(nums[r]<0){
                    return r;
                }else{
                    nums[r]=nums[r]*-1;
                    continue;
                }
            }
            if(nums[val]<0){
                return val;
            }else{
                nums[val] = nums[val]*-1;
            }
        }
        return -1;
    }
}