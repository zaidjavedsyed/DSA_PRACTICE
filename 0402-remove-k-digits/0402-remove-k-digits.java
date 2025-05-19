class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<num.length();i++){
            while(!st.isEmpty() && k>0 && (st.peek()-'0')>(num.charAt(i)-'0')){
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while(k>0){
            st.pop();
            k--;
        }
        if(st.isEmpty()){
            return "0";
        }
        String ans="";
        while(!st.isEmpty()){
            ans =st.pop()+ans;
        }
        if(ans.equals("0")){
            return "0";
        }
        
        while(ans.length()>1 && ans.charAt(0)=='0'){
            ans =ans.substring(1);
        }
        
        return ans;

    }
}