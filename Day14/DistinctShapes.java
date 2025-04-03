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

class DistinctShapes{
    public static int numDistinctIslands(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Set<String> uniqueIslands = new HashSet<>();
        boolean[][] visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    List<String> shape = new ArrayList<>();
                    dfs(grid, i, j, visited, shape, i, j);
                    uniqueIslands.add(String.join(",", shape));
                }
            }
        }
        return uniqueIslands.size();
    }

    private static void dfs(int[][] grid, int i, int j, boolean[][] visited, List<String> shape, int baseRow, int baseCol) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) {
            return;
        }

        visited[i][j] = true;
        shape.add((i - baseRow) + "_" + (j - baseCol)); // Store relative position

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Right, Down, Left, Up
        for (int[] d : directions) {
            dfs(grid, i + d[0], j + d[1], visited, shape, baseRow, baseCol);
        }
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
       System.out.println(numDistinctIslands(wall));
    }
}
