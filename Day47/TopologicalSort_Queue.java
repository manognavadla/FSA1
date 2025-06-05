import java.util.*;
class Solution
    {
    public List<Integer> topologicalSort(int N, ArrayList<ArrayList<Integer>> adj)
    {
        int[] indegree = new int[N];
        // Compute indegree of each node
        for (int i = 0; i < N; i++)
        {
            for (int node : adj.get(i))
            {
            indegree[i]++;
            }   
        }
        for(int i: indegree) System.out.print(i+" ");
        for(int i=0;i<N;i++){
            System.out.println(i+ "->"+ adj.get(i));
        }
        Queue<Integer> q = new LinkedList<>();
        // Add all nodes with indegree 0 to the queue
        for (int i = 0; i < N; i++)
        {
            if (indegree[i] == 0)
            {
            q.add(i);
            }
        }
        List<Integer> topoOrder = new ArrayList<>();
        int count = 0;
        while (!q.isEmpty())
        {
            int node = q.poll();
            topoOrder.add(node);
            count++;
            for (int neighbor : adj.get(node))
            {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0)
                {
                    q.add(neighbor);
                }
            }
        }
        // If cycle exists
        if (count != N)
        {
            return new ArrayList<>(); // Empty list indicates a cycle
        }
        return topoOrder;
    }
}
public class TopologicalSort_Queue {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int E = sc.nextInt();
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < N; i++) {
    adj.add(new ArrayList<>());
    }
    for (int i = 0; i < E; i++) {
    int u = sc.nextInt();
    int v = sc.nextInt();
    adj.get(u).add(v); 
    }
    Solution sol = new Solution();
  List<Integer> result=sol.topologicalSort(N, adj);
    if (result.isEmpty()) {
    System.out.println("Graph contains a cycle. Topological sort not possible.");
    } else {
    System.out.println("Topological order is:");
    for (int node : result) {
    System.out.print(node + " ");
    }
    System.out.println();
    }
    sc.close();
}
}