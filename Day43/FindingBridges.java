/*
 * Given an undirected graph of V vertices and E edges. 
Our task is to find all the bridges in the given undirected graph. 

A bridge in any graph is defined as an edge which, when removed, makes the graph disconnected.

Sample Input-1:
---------------
4 //no of vertices
3 //no of edges
0 1
0 2
1 3

Sample Output-1:
----------------
1 3
0 1
0 2

Sample Input-2:
---------------
5 
5
1 0
1 2
0 2
3 0
3 4

Sample Output-2:
---------------
3 4
0 3


 */

 import java.io.*;
import java.util.*;

class FindingBridges 
{
    private int V;   // No. of vertices    
	// Array  of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];
    int time = 0;

	// Constructor
	FindingBridges (int v)
    {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }
    void addEdge(int v, int w)
    {
        adj[v].add(w); 
        adj[w].add(v);   
    }
    void bridge() {
        boolean visited[] = new boolean[V];
        int disc[] = new int[V]; 
        int low[] = new int[V];
        int parent[] = new int[V];

        Arrays.fill(parent, -1);

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                bridgeUtil(i, visited, disc, low, parent);
            }
        }
    }

    void bridgeUtil(int u, boolean visited[], int disc[], int low[], int parent[]) {
        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (Integer v : adj[u]) {
            if (!visited[v]) {
                parent[v] = u;
                bridgeUtil(v, visited, disc, low, parent);

                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u]) {
                    System.out.println(u + " " + v);
                }
            }
            else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }


    public static void main(String args[])
    {      
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        
		FindingBridges g = new FindingBridges (v);
        for(int i=0;i<e;i++)
        {
            int end1=sc.nextInt();
            int end2=sc.nextInt();
            g.addEdge(end1,end2);
        }
        g.bridge();       
    }
}