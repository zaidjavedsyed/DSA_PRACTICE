/*Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
Stack s = new Stack<>();
int m = Integer.MAX_VALUE;
Implement the MinStack class:
void push(int val) pushes the element val onto the stack.
s.push(val)
m =Math.min(m,val);


*/
class MinStack {
   Stack<Integer> mainst;
   Stack<Integer> minst;

    public MinStack() {
        mainst = new Stack<>();
        minst = new Stack<>();
    }
    
    public void push(int val) {
        mainst.push(val);
        if(minst.isEmpty() ||val <= minst.peek()){
            minst.push(val);
        }
    }
    
    public void pop() {
        if(mainst.peek().equals(minst.peek())){
            mainst.pop();
            minst.pop();
        }else{
            mainst.pop();
        }

    }
    
    public int top() {
        return mainst.peek();
    }
    
    public int getMin() {
        return minst.peek();
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