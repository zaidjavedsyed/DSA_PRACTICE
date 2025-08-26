class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        long nn = Math.abs((long)n);
        while(nn>=1){
            if(nn%2==1){
                ans=ans*x;
                nn=nn-1;
            }else{
                x = x*x;
                nn=nn/2;
            }
        }
        if(n>=0){
            return ans;
        }else{
            return 1/ans;
        }
    }
}