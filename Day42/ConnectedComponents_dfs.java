package Day42;
/*
 * There are N cities, and M routes[], each route is a path between two cities.
routes[i] = [city1, city2], there is a travel route between city1 and city2.
Each city is numbered from 0 to N-1.
 
There are one or more Regions formed among N cities. 
A Region is formed in such way that you can travel between any two cities 
in the region that are connected directly and indirectly.
 
Your task is to findout the number of regions formed between N cities. 
 
Input Format:
-------------
Line-1: Two space separated integers N and M, number of cities and routes
Next M lines: Two space separated integers city1, city2.
 
Output Format:
--------------
Print an integer, number of regions formed.
 
 
Sample Input-1:
---------------
5 4
0 1
0 2
1 2
3 4
 
Sample Output-1:
----------------
2
 
 
Sample Input-2:
---------------
5 6
0 1
0 2
2 3
1 2
1 4
2 4
 
Sample Output-2:
----------------
1
 
 */
import java.util.*;
class ConnectedComponents_dfs {
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
                dfs(adjList,i,vis);
                comp++;
            }
        }
        return comp;
    }    
    public void dfs(List<List<Integer>> adjList, int i, boolean[] vis){
       Stack<Integer> stack = new Stack<>();
        stack.push(i);
        vis[i] = true; 
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            for (int neighbor : adjList.get(curr)) {
                if (!vis[neighbor]) {
                    stack.push(neighbor);
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
        int result = new ConnectedComponents_dfs().countComponents(n, edges);
        System.out.println(result);
    }
}
/*
 * class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(n>connections.length+1) return -1;
        boolean[] vis= new boolean[n];
        List<List<Integer>> adjList= new ArrayList<>();
        for(int i=0;i<n;i++) adjList.add(new ArrayList<>());
        for(int[] con: connections){
            adjList.get(con[0]).add(con[1]);
            adjList.get(con[1]).add(con[0]);
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                count++;
                dfs(adjList, i, vis);
            }
        }
        return count-1;
    }
    public void dfs(List<List<Integer>> adjList, int i, boolean[] vis){
        vis[i]=true;
        for(Integer j: adjList.get(i)){
            if(!vis[j]){
                dfs(adjList, j, vis);
            }
        }
    }
}
 */