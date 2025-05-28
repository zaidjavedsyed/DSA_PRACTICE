class Solution {
    public int maxScore(int[] cardPoints, int k) {
    int l=k-1;
    int r= cardPoints.length-1;
    int sum=0;
    for(int i =0;i<k;i++){
        sum=sum+cardPoints[i];
    }
    int maxsum = sum;
    while(l>=0){
        sum = sum-cardPoints[l];
        l--;
        sum=sum+cardPoints[r];
        maxsum = Math.max(maxsum,sum);
        r--;
    }
    return maxsum;
    }
}