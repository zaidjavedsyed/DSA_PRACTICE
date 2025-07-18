class Solution {
    public String largestOddNumber(String num) {
      String ans= "";
      for(int i=0;i<num.length();i++){
        if((int)num.charAt(i)%2!=0){
            ans = num.substring(0,i+1);
        }
      }
      return ans;
    }}
                /*
                w=w+n;
                continue;
            }
            else{
                w=w+n;
                if(max<Integer.parseInt(w)){
                    max=Integer.parseInt(w);
                }
                
            }
        }
        if(max==0){
            return "";
        }
        return Integer.toString(max);
    }
}*/