class MyQueue {
    Stack<Integer> s = new Stack<>();
    public MyQueue() {
        
    }
    public void push(int x) {
        if(s.isEmpty()){
            s.push(x);
            return;
        }
        int a =s.pop();
        push(x);
        s.push(a);
    
       }
    
    public int pop() {
        return s.pop();
    }
    
    public int peek() { 
        return s.peek();
        
    }
    
    public boolean empty() {
        return s.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */