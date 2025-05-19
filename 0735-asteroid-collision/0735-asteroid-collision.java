class Solution {
    public int[] asteroidCollision(int[] asteroids) {
      Stack<Integer> st  = new Stack<>();
      for(int i = asteroids.length-1;i>=0;i--){
        if(st.isEmpty()){
            st.push(asteroids[i]);
        }else{
            if(asteroids[i]>0 && st.peek()<0){
                while(!st.isEmpty() &&asteroids[i]>0 && st.peek()<0&&Math.abs(asteroids[i])>Math.abs(st.peek())){
                        st.pop();
                    }
                if(st.isEmpty()){
                      st.push(asteroids[i]);  
                      continue;
                }else if(!(asteroids[i]>0 && st.peek()<0)){
                    st.push(asteroids[i]);
                }
                else if(Math.abs(asteroids[i])<Math.abs(st.peek())){
                    continue;
                }else{
                    st.pop();
                    continue;
                }
                    
            }else{
                st.push(asteroids[i]);
            }
      }}
     
        int[] array = new int[st.size()];
        int index = 0;

        while (!st.isEmpty()) {
            array[index++] = st.pop();
        }
        return array;  
    
}}