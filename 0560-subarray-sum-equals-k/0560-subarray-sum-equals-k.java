class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> hp = new HashMap<>();
        int prefixSum =0;
        int count =0;
        hp.put(0,1);
        for(int i=0;i<n;i++){
            prefixSum+=nums[i];
            if(hp.containsKey(prefixSum-k)){
                count+=hp.get(prefixSum-k);
            }
            hp.put(prefixSum,hp.getOrDefault(prefixSum,0)+1);
        }
        return count;

    }
}