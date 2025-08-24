class Solution {
    public int divide(int dividend, int divisor) {
       if(dividend == divisor){
        return 1;
       } 
       boolean sign = (dividend<0 == divisor<0);
       long divid = Math.abs((long)dividend);
       long divis = Math.abs((long)divisor);
       long ans = 0;
       while(divid>=divis){
        long count =0;
        while(divid> (divis<<(count+1))){
            count++;
        }
        ans += 1<<count;
        divid = (divid - (divis<<(count)));
       }
       if((ans>=(1L<<31)) && sign==true){
        return Integer.MAX_VALUE;
       }
       if(ans >=(1L<<31) && sign == false){
       return Integer.MIN_VALUE;
       }
       if(sign){
        return (int)ans;
       }else{
        return (int)ans*-1;
       }
    }
}