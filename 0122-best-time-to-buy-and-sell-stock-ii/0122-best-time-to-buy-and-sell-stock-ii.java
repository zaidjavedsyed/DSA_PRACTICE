class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int tp =0;
        for(int i=0;i<prices.length;i++){
            int at = tp;
            tp= Math.max(tp,tp+prices[i]-min);
            if(at!=tp){
                min = prices[i];
            }else{
                min = Math.min(min,prices[i]);
            }
        }
        return tp;
    }
}