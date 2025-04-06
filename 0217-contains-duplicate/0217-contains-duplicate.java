class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer,Integer> hp  = new HashMap<>();
        for(int j=0;j<nums.length;j++){
            hp.put(nums[j],0);
        }
        for(int i=0;i<nums.length;i++){
            hp.put(nums[i],hp.get(nums[i])+1);
            if(hp.get(nums[i])>1){
                return true;
            }
        }
        return false;
    }
}