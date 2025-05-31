class counting{
    int num;
    int count;
    public counting(int num,int count){
        this.num=num;
        this.count = count;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<counting> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(counting c1,counting c2){
                return -Integer.compare(c1.count,c2.count);
            }
        });
        HashMap<Integer,Integer> hp = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            hp.put(nums[i],hp.getOrDefault(nums[i],0)+1);
        }
        for(int h:hp.keySet()){
            pq.add(new counting(h,hp.get(h)));
        }
        List<Integer> ar = new ArrayList<Integer>();
        while(!pq.isEmpty() && k>0){
            ar.add(pq.poll().num);
            k--;
        }
        int[] result = new int[ar.size()];
        for (int i = 0; i < ar.size(); i++) {
            result[i] = ar.get(i);
        }
        return result;
    }
}