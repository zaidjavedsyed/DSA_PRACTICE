class Solution {
    public int minEatingSpeed(int[] piles, int h) {
     boolean flag = true;
     int k =1;
     int low =1;
     int high = 2;
     int ans = Integer.MAX_VALUE;
     for(int hi:piles){
        high = Math.max(hi,high);
     }
     while(low<=high){
        int mid = low + (high-low)/2;
        if(canEatAll(mid,h,piles)){
            ans = Math.min(ans,mid);
            high = mid-1;
        }else{
            low = mid+1;
        }
     }
     return ans;   
    }
    public boolean canEatAll(int k,int h,int[] piles){
        int th=0;
        for(int pile:piles){
            th+= Math.ceil((double)pile/(double)k);
            if(th>h){
                return false;
            }
        }
        return true;

    }
}