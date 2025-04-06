class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
       List<Integer> ar = new ArrayList<>();
       List<Integer> ans = new ArrayList<>();
       Arrays.sort(nums);
       int n=nums.length;
       int i=0;
       for(int k=1;k<=n;k++){
        ar.add(k);
       }
       int j=0;
       while(i<n && j<n){
        if(ar.get(j)==nums[i]){
            i++;
            j++;
        }
        else if(nums[i]<ar.get(j)){
            i++;
        }
        else if(ar.get(j)<nums[i]){
            ans.add(ar.get(j));
            j++;
        }
       }
       while(j<n){
        ans.add(ar.get(j));
        j++;
       }
       return ans;
    }
}