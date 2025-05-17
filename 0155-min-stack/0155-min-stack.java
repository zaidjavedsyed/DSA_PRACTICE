class MinStack {
Stack<Integer> s = new Stack<>();
Queue<Integer> q = new PriorityQueue<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        s.push(val);
        q.add(val);
    }
    
    public void pop() {
        q.remove(s.pop());
    }
    
    public int top() {
    return s.peek();
    
    }
    
    public int getMin() {
        return q.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */