class MyStack {
     Queue<Integer> q1 = new LinkedList<>();
    public MyStack() {
    }
    
    public void push(int x) {
        q1.add(x);
        for(int i=1;i<q1.size();i++){
            q1.add(q1.remove());
        }
    }
    
    public int pop() {
       
        return q1.remove();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        if(q1.isEmpty()){
            return true;
        }else{
            return false;

        }
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */