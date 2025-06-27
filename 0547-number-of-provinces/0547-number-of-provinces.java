class Solution {
    public void dfs(int node,List<List<Integer>> adjl,boolean[] visited){
        visited[node]=true;
        for(int i:adjl.get(node)){
            if(!visited[i]){
                dfs(i,adjl,visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adjl  = new ArrayList<>();
       int count =0;
       int V = isConnected.length;
        boolean[] visited = new boolean[V];
       for (int i = 0; i < V; i++) 
       {adjl.add(new ArrayList<>());}
       
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[i].length;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adjl.get(i).add(j);
                }
            }}
       
            for(int i=0;i<isConnected.length;i++){
                if(!visited[i]){
                    dfs(i,adjl,visited);
                    count++;
                }
            }
        
        return count;
    }
}