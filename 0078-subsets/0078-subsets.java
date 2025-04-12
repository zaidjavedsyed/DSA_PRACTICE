class Solution {
    public static void Allsubsets(int[] nums,int i, List<Integer> ans,List<List<Integer>> ta){
        if(i==nums.length){
            ta.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums[i]);
    
        Allsubsets(nums,i+1,ans,ta);
        int index= ans.size()-1;
        ans.remove(index);    
        Allsubsets(nums,i+1,ans,ta);
    }
    public List<List<Integer>> subsets(int[] nums){
        int i =0;
        List<List<Integer>> ta1 = new ArrayList<>();
        Allsubsets(nums,i,new ArrayList<>(),ta1);
        return ta1;

    }
}