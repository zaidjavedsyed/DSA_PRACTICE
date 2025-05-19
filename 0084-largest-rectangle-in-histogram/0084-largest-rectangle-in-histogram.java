class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        // New array with sentinels at both ends
        int[] h = new int[n + 2];
        for (int i = 0; i < n; i++) {
            h[i + 1] = heights[i];
        }
        // h[0] and h[n+1] are 0 by default

        Deque<Integer> stack = new ArrayDeque<>();
        long maxArea = 0;

        for (int i = 0; i < h.length; i++) {
            // While the current bar is lower than the bar at stack top
            while (!stack.isEmpty() && h[i] < h[stack.peekLast()]) {
                int height = h[stack.removeLast()];
                // width is between the new top (after pop) and i
                int width = i - stack.peekLast() - 1;
                long area = (long) height * width;
                if (area > maxArea) {
                    maxArea = area;
                }
            }
            stack.addLast(i);
        }

        return (int) maxArea;
    }
}
