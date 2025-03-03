package Day14;
/*
 * Viraj Aanand is a wedding planner, He ordered his assistant to decorate a wall.
The decorator plans to decorate the wall with two different colored balloons.
The wall size is M*N, The decorator can decorate the wall using M*N balloons
the balloons are blue or white in color.

Blue colored ballons represented with digit-1 and 
White colored ballons represented with digit-0.

The blue colored balloons forms different shapes, that are connected 4 directonally.
The directons are upwards, downwards, left, and right. Viraj Aanand got an idea to 
count the unique shapes formed by blue colored ballons.

You will be given the decorated wall as a matrix wall[][].
Your task is to help, Viraj Aanand to count the unique shapes.

Input Format:
-------------
Line-1: Two space separated integers M and N, size of the wall.
Next M lines: N space separated integers, either 0 or 1.

Output Format:
--------------
Print an integer, Number of distinct shapes formed by blue balloons.


Sample Input-1:
---------------
4 5
1 1 0 0 0
1 1 0 0 0
0 0 0 1 1
0 0 0 1 1

Sample Output-1:
----------------
1


Sample Input-2:
---------------
5 5
1 1 0 1 1
1 0 0 0 1
0 0 0 0 0
1 0 0 0 1
1 1 0 1 1

Sample Output-2:
----------------
4

 */
import java.util.*;

class DistinctShapesBFS {
    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // Down, Up, Right, Left

    public static int countDistinctShapes(int[][] wall,int m,int n) {
        boolean[][] visited = new boolean[m][n];
        Set<String> uniqueShapes = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (wall[i][j] == 1 && !visited[i][j]) {
                    String shape = bfs(i, j, wall, visited);
                    uniqueShapes.add(shape);
                }
            }
        }

        return uniqueShapes.size();
    }

    private static String bfs(int x, int y, int[][] wall, boolean[][] visited) {
        int rows = wall.length, cols = wall[0].length;
        Queue<int[]> queue = new LinkedList<>();
        List<String> shape = new ArrayList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        int baseX = x, baseY = y;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int curX = cell[0], curY = cell[1];
            shape.add((curX - baseX) + "," + (curY - baseY)); // Relative position

            for (int[] dir : directions) {
                int newX = curX + dir[0], newY = curY + dir[1];
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols &&
                    wall[newX][newY] == 1 && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }

        Collections.sort(shape); 
        return String.join("|", shape); 
    }

    public static void main(String[] args) {
       Scanner sc= new Scanner(System.in);
       int m=sc.nextInt();
       int n= sc.nextInt();
       int[][] wall= new int[m][n];
       for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            wall[i][j]=sc.nextInt();
        }
       }
       System.out.println(countDistinctShapes(wall, m,n));
    }
}
