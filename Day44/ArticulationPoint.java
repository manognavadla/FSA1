/*
 * A vertex is said to be an articulation point in a graph 
if removal of the vertex and associated edges disconnects the graph.

So, the removal of articulation points increases the number of connected components in a graph.

The main aim here is to find out all the articulations points in a graph.


Sample Input-1:
---------------
5
5
1 0
0 2
2 1
0 3
3 4

Sample Output-1:
----------------
[0, 3]

Sample Input-2:
---------------
4
3
0 1
1 2
2 3

Sample Output-2:
----------------
[1, 2]


Sample Input-3:
---------------
7
8
0 1 
1 2
2 0 
1 3
1 4
1 6
3 5
4 5

Sample Output-3:
----------------
[1]

Sample Input-4:
---------------
5
4
0 1
1 2
2 3
3 4

Sample Output-4:
----------------
[1, 2, 3]


 */
import java.util.*;

class ArticulationPoint {
    static int time;

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void APUtil(ArrayList<ArrayList<Integer>> adj, int u, boolean visited[],int disc[], int low[], int parent, boolean isAP[]) {
        // Count of children in DFS Tree
        int children = 0;

        // Mark the current node as visited
        visited[u] = true;

        // Initialize discovery time and low value
        disc[u] = low[u] = ++time;

        // Go through all vertices adjacent to this
        for (Integer v : adj.get(u)) {
            // If v is not visited yet, then make it a child of u in DFS tree and recur for it
            if (!visited[v]) {
                children++;
                APUtil(adj, v, visited, disc, low, u, isAP);

                // Check if the subtree rooted with v has a connection to one of the ancestors of u
                low[u] = Math.min(low[u], low[v]);

                // If u is not root and low value of one of its child is more than discovery value of u
                if (parent != -1 && low[v] >= disc[u])
                    isAP[u] = true;
            }
            // Update low value of u for parent function calls
            else if (v != parent) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        // If u is root of DFS tree and has two or more children
        if (parent == -1 && children > 1)
            isAP[u] = true;
    }

    static void AP(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] isAP = new boolean[V];
        time = 0;

        // Adding this loop so that the code works even if we are given a disconnected graph
        for (int u = 0; u < V; u++) {
            if (!visited[u])
                APUtil(adj, u, visited, disc, low, -1, isAP);
        }

        // Print articulation points
        for (int u = 0; u < V; u++) {
            if (isAP[u])
                System.out.print(u + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of vertices:");
        int V = sc.nextInt();

        System.out.println("Enter number of edges:");
        int e = sc.nextInt();

        ArticulationPoint g = new ArticulationPoint();
        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj1.add(new ArrayList<>());
        }

        System.out.println("Enter edges (u v):");
        for (int i = 0; i < e; i++) {
            int end1 = sc.nextInt();
            int end2 = sc.nextInt();
            g.addEdge(adj1, end1, end2);
        }

        System.out.println("Articulation points in the graph:");
        AP(adj1, V);
    }
}
