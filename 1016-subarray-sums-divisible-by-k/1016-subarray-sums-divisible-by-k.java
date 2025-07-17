class Solution {
    public int subarraysDivByK(int[] nums, int k) {
     HashMap<Integer,Integer> hp = new HashMap<>();
     hp.put(0,1);
     int count =0;
     int sum=0;
     for(int i=0;i<nums.length;i++){
        sum+=nums[i];
        int rem = sum%k;
        if(rem<0){
            rem = rem +k;
        }
        if(hp.containsKey(rem)){
            count+=hp.get(rem);
            hp.put(rem,hp.get(rem)+1);
        }else{
            hp.put(rem,1);
        }
     }
     return count;
    }
}