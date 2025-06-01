class Solution {
    public boolean checkValidString(String s) {
       int countl =0;
       int countr =0;
       for(int i=0;i<s.length();i++){
        if(s.charAt(i)==')'){
            countl--;
        }else{
            countl++;
        }
        if(countl<0){
            return false;
        }

       }
       for(int j=s.length()-1;j>=0;j--){
        if(s.charAt(j)=='('){
            countr--;
        }else{
            countr++;
        }
        if(countr<0){
            return false;
        }
       }
       return true;
    }
}