class Solution {
    public int findKthPositive(int[] arr, int k) {
        int i=0;
        int k1=0;
        int m;
        for(m=1;m<=arr[arr.length-1];m++){
            if(arr[i]==m){
                i++;
            }else{
                k1++;
                if(k1== k){
                return m;
                }
            }
        }
        while(k1!=k){
            m++;
            k1++;
        }
        return m-1;
    }
}