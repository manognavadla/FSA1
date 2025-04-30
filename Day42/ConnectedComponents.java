package Day42;
import java.util.*;
class ConnectedComponents {
     public int countComponents(int n, int[][] edges) {
        //Write your code here and return an integer
        List<List<Integer>> adjList= new ArrayList<>();
        for(int i=0;i<n;i++) adjList.add(new ArrayList<>());
        for(int[] e:edges){
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }
        boolean[] vis= new boolean[n];
        int comp=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                bfs(adjList,i,vis);
                comp++;
            }
        }
        return comp;
     }    
    public void bfs(List<List<Integer>> adjList, int i, boolean[] vis){
       Queue<Integer> queue = new ArrayDeque<>();
        queue.add(i);
        vis[i] = true; 
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int neighbor : adjList.get(curr)) {
                if (!vis[neighbor]) {
                    queue.add(neighbor);
                    vis[neighbor] = true;
                }
            }
        }
    }   
   //Any supporting functinalities, write here
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int e = sc.nextInt();
        int[][] edges = new int[e][2];        
        for (int i = 0; i < e; i++) {
            for (int j = 0; j < 2; j++) {
                edges[i][j] = sc.nextInt();
            }
        }        
        int result = new ConnectedComponents().countComponents(n, edges);
        System.out.println(result);
    }
}
