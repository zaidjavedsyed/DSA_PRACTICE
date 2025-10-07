/*Implement a last-in-first-out (LIFO) stack using only two queues.
Queue q1= new LinkedList();
Queue q2= new LinkedList();
Implement the MyStack class:
void push(int x) Pushes element x to the top of the stack.
q1.add(x); add it in one of the queue
int pop() Removes the element on the top of the stack and returns it.
while(q1.size()!=1){
    q2.add(q1.poll());
}
int a =q1.poll();
int n = q2.size();
while(q1.size()!=n){
    q1.add(q2.poll())
}
return a;
int top() Returns the element on the top of the stack.
while(q1.size()!=1){
    q2.add(q1.poll());
}
int a = q1.peek();
int n = q2.size();
while(q1.size()!=n){
    q1.add(q2.poll())
}
return a;
boolean empty() Returns true if the stack is empty, false otherwise.
return q1.isEmpty();



*/
class MyStack {
    Queue <Integer>q1;
    Queue <Integer>q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2=  new LinkedList<>();
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        while(q1.size()!=1){
            q2.add(q1.poll());
        }
        int a =q1.poll();
        int n = q2.size();
        while(q1.size()!=n){
            q1.add(q2.poll());
        }
        return a;
        
    }
    
    public int top() {
        while(q1.size()!=1){
            q2.add(q1.poll());
        }
        int a =q1.poll();
        int n = q2.size();
        while(q1.size()!=n){
            q1.add(q2.poll());
        }
        q1.add(a);
        return a;
        
    }
    
    public boolean empty() {
        return q1.isEmpty();
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