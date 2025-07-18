class Solution {
    public int longestcommon(String s1,String s2){
        int minlength = Math.min(s1.length(),s2.length());
        int j=0;
        while(j<minlength && s1.charAt(j)==s2.charAt(j)){
            j++;
        }
        return j;
    }
    public String longestCommonPrefix(String[] strs) {
      if(strs.length==0){
        return "";
      }
      if(strs.length==1){
        return strs[0];
      }
      String s=strs[0];
      int minl = Integer.MAX_VALUE;
      for(int i=1;i<strs.length;i++){
        int x =longestcommon(strs[i],s);
        minl = Math.min(minl,x);
      }
      String ans = "";
      for(int k=0;k<minl;k++){
        ans= ans+s.charAt(k);
      }
      return ans;
    }
}