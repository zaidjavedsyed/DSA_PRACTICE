class KthLargest {
    int k1;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        k1=k;
        if(k>nums.length){
            for(int i=0;i<nums.length;i++){
                pq.add(nums[i]);
            }
        }else{
        for(int i=0;i<k;i++){
            pq.add(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            pq.add(nums[i]);
            pq.poll();
        }}
    }
    
    public int add(int val) {
        if(k1>pq.size()){
          pq.add(val);  
        }else{
        pq.add(val);
        pq.poll();}
        return pq.peek();
        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */