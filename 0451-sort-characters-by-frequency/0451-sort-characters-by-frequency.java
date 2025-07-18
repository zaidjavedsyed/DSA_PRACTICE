class Solution {
    public String frequencySort(String s) {
        Map<Character,Integer> hp =new HashMap<>();
        StringBuilder ans = new StringBuilder();
        for(char ch:s.toCharArray()){
            hp.put(ch,hp.getOrDefault(ch,0)+1);
        }
        List<Character> l = new ArrayList<>(hp.keySet());
        l.sort((ob1,ob2)-> hp.get(ob2)-hp.get(ob1));
        for(char ch:l){
            for(int i=0;i<hp.get(ch);i++){
                ans.append(ch);
            }
        }
        return ans.toString();
    }
    
}