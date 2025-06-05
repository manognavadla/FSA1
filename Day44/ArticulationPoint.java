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
        int children = 0;
        visited[u] = true;
        disc[u] = low[u] = ++time;
        for (Integer v : adj.get(u)) {
            if (!visited[v]) {
                children++;
                APUtil(adj, v, visited, disc, low, u, isAP);
                low[u] = Math.min(low[u], low[v]);
                if (parent != -1 && low[v] >= disc[u])
                    isAP[u] = true;
            }
            else if (v != parent) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
        if (parent == -1 && children > 1)
            isAP[u] = true;
    }

    static void AP(ArrayList<ArrayList<Integer>> adj, int V) {
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] isAP = new boolean[V];
        time = 0;
        for (int u = 0; u < V; u++) {
            if (!visited[u])
                APUtil(adj, u, visited, disc, low, -1, isAP);
        } 
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
