class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> h1 = new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            h1.put(nums1[i],i);
        }
        int [] arr1 = new int[nums1.length];
        int r=-1;
       // ArrayList<Integer> arr = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        for(int j=nums2.length-1;j>=0;j--){
            if(st.isEmpty()){
                 r=-1;

            }else{
            while(!st.isEmpty() && nums2[j]>st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                 r=-1;

            }else{
            if(nums2[j]<st.peek()){
                 r=st.peek();
            }}}
            st.push(nums2[j]);
            if(h1.get(nums2[j])!=null){
                int id =h1.get(nums2[j]);
                arr1[id]=r;
            }
            
            }
            return arr1;
            
    }
}