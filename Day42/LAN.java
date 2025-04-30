package Day42;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * In your computer lab, network switches are connected using Ethernet cables to form a LAN. 
However, a new hardware technician inadvertently connected switches in a way that created a cycle,
resulting in a network loop. 
As a consequence, the network has become unstable. You need to identify and remove the specific cable that 
is causing the loop. 
If there are multiple cables contributing to the loop, you should remove the one that was most recently added

Sample Input-1:
---------------
3
0 1
0 2
1 2

Sample Output-1:
----------------
[1 2]

Sample Input-2:
---------------
5
0 1
1 2
2 3
0 3
0 4

Sample Output-2:
----------------
[0,3]
 

Constraints:
------------
-> n == edges.length
-> 3 <= n <= 1000
-> edges[i].length == 2
-> 1 <= ai < bi <= edges.length
-> ai != bi
-> There are no repeated edges.
-> The given graph is connected.
 */
class DisjointSet
{
	private int[] parent;   
	public DisjointSet(int V) 
	{
		parent = new int[V];
		for (int i=0; i<V; i++) {
			parent[i] = i;
		}
	}
	public int find(int u)
	{
		return parent[u] == u ? u : (parent[u] = find(parent[u]));
	}
    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return false; 
        parent[py] = px;
        return true;
    }
}

class LAN
{
	
    public static int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n);

        for (int[] edge : edges) {
            if (!ds.union(edge[0], edge[1])) {
                return edge; 
            }
        }

        return new int[0]; 
    }


	public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] edges = new int[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                edges[i][j] = sc.nextInt();
            }
        }   
        int[] result = findRedundantConnection(edges);  
        System.out.print(result.length==2?result[0]+" "+result[1]:"[]");    
    }
}

