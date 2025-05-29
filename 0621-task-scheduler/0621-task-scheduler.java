class Task{
    int count;
    int time;
    public Task(int time,int count){
        this.time = time;
        this.count=  count;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] arr = new int[26];
        for(char task: tasks){
            arr[task-'A']++;
        }
        PriorityQueue<Task> pq = new PriorityQueue(new Comparator<Task>(){
            public int compare(Task t1,Task t2){
                return -Integer.compare(t1.count,t2.count);
            }
        });
        Queue<Task> q = new LinkedList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=1){
                pq.add(new Task(0,arr[i]));
            }
        }
        int time =0;
        while(!pq.isEmpty() || !q.isEmpty()){
            if(!q.isEmpty() && time-q.peek().time>n){
                pq.add(q.poll());
            }
            if(!pq.isEmpty()){
               Task t= pq.poll();
               t.count--;
               t.time = time;
               if(t.count>0){
               q.add(t);}
            }
            time++;
        }
        return time;
    }
}


