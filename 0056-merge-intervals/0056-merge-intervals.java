class Solution {
    public int[][] merge(int[][] intervals) {
       int i =1;
       int n =intervals.length;

       List<int[]> result = new ArrayList<>();
       Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        int [] current = intervals[0];
       while(i<n){if(current[1]>=intervals[i][0]){
        current[0] = Math.min(current[0],intervals[i][0]);
        current[1]=Math.max(current[1],intervals[i][1]);
        i++;
       }else{result.add(current);
       current = intervals[i];
       i++;

       }}
        result.add(current);
       return result.toArray(new int[result.size()][]);
    
}}