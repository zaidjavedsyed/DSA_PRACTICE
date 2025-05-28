class Solution {
    public int numberOfSubstrings(String s) {
     int[] lastscene = {-1,-1,-1};
     int count =0;
     for(int i =0;i<s.length();i++){
        lastscene[s.charAt(i)-'a']=i;
        if(lastscene[0]!=-1 && lastscene[1]!=-1 && lastscene[2]!=-1){
            count = count +1+ Math.min(lastscene[0],Math.min(lastscene[1],lastscene[2]));
        }
     }
     return count;
    }
}
