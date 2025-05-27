class Solution {

    public int subarrayLessthanequalgoal(int[] nums,int goal){
    if(goal<0){
        return 0;
    }
    int l=0;
    int r=0;
    int ans=0;
    int sum=0;
    while(r<nums.length){
        sum+=nums[r];
        while(sum>goal){
            sum=sum-nums[l];
            l++;
        }
        ans =ans+r-l+1;
        r++;
    }
    return ans;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
    int g = subarrayLessthanequalgoal(nums,goal);
    int l = subarrayLessthanequalgoal(nums,goal-1);
    return g-l;
    }
}