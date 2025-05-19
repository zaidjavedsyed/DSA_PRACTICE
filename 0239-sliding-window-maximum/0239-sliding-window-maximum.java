class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // result will have length n - k + 1
        int[] res = new int[n - k + 1];
        // deque holds indices, values in nums[deque[..]] are in decreasing order
        Deque<Integer> deque = new ArrayDeque<>();
        
        for (int i = 0; i < n; i++) {
            // 1) remove indices whose value is <= current, from the back
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.removeLast();
            }
            // 2) add current index
            deque.addLast(i);
            
            // 3) remove front if it's out of this window
            if (deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }
            
            // 4) record result when the first window is fully seen
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        
        return res;
    }
}
