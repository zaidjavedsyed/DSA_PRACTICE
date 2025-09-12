class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(k*m>bloomDay.length){
            return -1;
        }
        int low = 0;
        int high = 0;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            high  = Math.max(high,bloomDay[i]);
        }
        while(low<=high){
            int mid = low +(high-low)/2;
            if(isBooque(mid,k,m,bloomDay)){
                ans = Math.min(ans,mid);
                high=mid-1;
            }else{
                low = mid+1;
            }
        }
        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        return ans;
        /*
        for(int a=1;a<=high;a++){
            int m1 = m;
            int b=0;
            for(int i=0;i<bloomDay.length;i++){
                if(bloomDay[i]<=a){
                    b+=1;
                    if(b==k){
                        m1--;
                        b=0;
                    }
                }else{
                    b=0;
                }
                if(m1==0){
                    return a;
                }
            }
        }
        return -1;*/
    }
    public boolean isBooque(int a,int k,int m,int[] bloomDay){
        int b=0;
        for(int bl:bloomDay){
            if(bl<=a){
                b+=1;
                if(b==k){
                    m--;
                    b=0;
                }
                if(m==0){
                    return true;
                }
            }else{
                b=0;
            }
        }
        return false;
    }
}