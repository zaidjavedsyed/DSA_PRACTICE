class Solution {
    private static final int MOD = 1_000_000_007;
    public int[] nextsmallest(int[] arr){
        int n=arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans= new int[arr.length];
        for(int j=n-1;j>=0;j--){
            while(!st.isEmpty() && arr[j]<arr[st.peek()]){
                st.pop();
            }
           ans[j] = st.isEmpty()?n:st.peek();
            st.push(j);
            }
            return ans;
    }
    public int[] prevsmallest(int[] arr){
        int n=arr.length;
        Stack<Integer> st = new Stack<>();
        int[] ans= new int[arr.length];
        for(int j=0;j<n;j++){
            while(!st.isEmpty() && arr[j]<=arr[st.peek()]){
                st.pop();
            }
            ans[j]=st.isEmpty()?-1:st.peek();
            st.push(j);
            }
            return ans;
    }
    
    public int sumSubarrayMins(int[] arr) {
        int[] prev = prevsmallest(arr);
        int[] next = nextsmallest(arr);
        int n = arr.length;
        long total =0L;
        for(int i=0;i<n;i++){
            int frontel = next[i]-i;
            int prevel= i-prev[i];
            long contrib=(long)frontel*prevel*arr[i];
            total = (total+contrib%MOD)%MOD;
        }
    
    return (int)total;}
}