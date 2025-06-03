class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[1],b[1]));
        int[] current = intervals[0];
        int n=intervals.length;
        int c=0;
        for(int i =1;i<n;i++){
            if(current[1]>intervals[i][0]){
               // current[0] =Math.min(current[0],intervals[i][0]);
               // current[1] =Math.max(current[1],intervals[i][1]);
                c++;
            }else{
                current = intervals[i];
            }
        }
        return c;
    }
}