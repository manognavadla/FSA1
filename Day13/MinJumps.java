/*
 * Given an array of integers arr, you are initially positioned at the first index of the array.

In one step you can jump from index i to index:
i + 1 where: i + 1 < arr.length.
i - 1 where: i - 1 >= 0.
j where: arr[i] == arr[j] and i != j.

Return the minimum number of steps to reach the last index of the array.

Notice that you can not jump outside of the array at any time.

Input Format:
-------------
Line-1: An integer n
Line-2: n space separated integers

Output Format:
--------------
Line-1: An integer

Sample Input-1:
---------------
10
100 -23 -23 404 100 23 23 23 3 404

Sample Output-1:
----------------
3

Explanation: You need three jumps from index 0 --> 4 --> 3 --> 9. Note that index 9 is the last index of the array.

Sample Input-2:
---------------
1
7

Sample Output-2: 
----------------
0

Explanation: Start index is the last index. You do not need to jump.

Sample Input-3:
---------------
8
7 6 9 6 9 6 9 7

Sample Output-3:
----------------
1

Explanation: You can jump directly from index 0 to index 7 which is last index of the array.
 
 Constraints:
 ------------
1 <= arr.length <= 5 * 10^4
-10^8 <= arr[i] <= 10^8
 */
import java.util.*;

public class MinJumps {
    public static int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;  // If already at the last index, no jumps needed
        
        // Map values to all their positions
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0); // Start BFS from index 0
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int s = 0; s < size; s++) {
                int i = queue.poll();
                
                // If we reach the last index, return the number of jumps
                if (i == n - 1) return steps;

                // Explore neighbors
                List<Integer> neighbors = new ArrayList<>();
                if (i - 1 >= 0) neighbors.add(i - 1); // Left move
                if (i + 1 < n) neighbors.add(i + 1);  // Right move
                if (graph.containsKey(arr[i])) {
                    neighbors.addAll(graph.get(arr[i])); // Jump to same value indices
                }

                for (int next : neighbors) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                    }
                }
                
                // Clear the list to avoid redundant future checks
                graph.remove(arr[i]);
            }
            steps++;  // Increment jump count
        }
        
        return -1;  // Should not reach here
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println(minJumps(arr));
    }
}
