class Solution {
    public String frequencySort(String s) {
        char[] ch = s.toCharArray();
        String ans = "";
        HashMap<Character,Integer> hp = new HashMap<>();
        for(char c:ch){
            hp.put(c,hp.getOrDefault(c,0)+1);
        }
        List<Character> l = new ArrayList<>(hp.keySet());
        l.sort((ob1,ob2)-> hp.get(ob2)-hp.get(ob1));
        for(Character c:l){
            int count = hp.get(c);
            while(count>0){
                ans = ans + c;
                count--;
            }
        }
        return ans;
    }
}