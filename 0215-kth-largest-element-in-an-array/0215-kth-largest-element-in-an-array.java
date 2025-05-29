class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minh  = new PriorityQueue<>();
        for(int i=0;i<k;i++){
            minh.add(nums[i]);
        }
        for(int i =k;i<nums.length;i++){
            minh.add(nums[i]);
            minh.poll();
        }
        return minh.peek();

        
    }
}