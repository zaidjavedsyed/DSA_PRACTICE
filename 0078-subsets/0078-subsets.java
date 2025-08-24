class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int subsets = 1<<nums.length;
        List<List<Integer>> ta = new ArrayList<>();
        for(int i=0;i<subsets;i++){
            List<Integer> ar = new ArrayList<>();
            for(int j=0;j<nums.length;j++){
                if((i&(1<<j))!=0){
                    ar.add(nums[j]);
                }
            }
            ta.add(ar);
        }
        return ta;
    }
}