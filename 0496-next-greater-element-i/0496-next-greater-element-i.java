// Next Greater Element I
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hp = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            hp.put(nums1[i],i);
        }
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums1.length];
        for(int i=nums2.length-1;i>=0;i--){
            int r=-1;
            if(st.isEmpty()){
                r=-1;
            }else{
                while(!st.isEmpty() && nums2[i]>st.peek()){
                    st.pop();
                }
                if(st.isEmpty()){
                    r=-1;
                }else{
                    if(st.peek()>=nums2[i]){
                        r=st.peek();
                    }
                }
            }
            st.push(nums2[i]);
            if(hp.get(nums2[i])!=null){
                ans[hp.get(nums2[i])]=r; 
            }
        }
        return ans;
    }
}