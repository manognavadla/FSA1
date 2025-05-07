/*
 * Ibrahim is an interior designer wants to color wall of size M*N. 
He plans to color the wall and put lights of two different colors

The designer can lit the wall using M*N lights.The lights are Blue or pink
in color. Blue colored lights represented with digit-1 and pink colored lights 
represented with digit-0.

The Blue colored lights forms different shapes, that are connected 4 directonally.
The directons are upwards, downwards, left, and right. Ibrahim got an idea to 
count the unique shapes formed by blue colored lights.

You will be given the decorated wall as a matrix wall[][].
Your task is to help Ibrahim to count the unique shapes by the lights.

Input Format:
-------------
Line-1: Two space separated integers M and N, size of the wall.
Next M lines: N space separated integers, either 0 or 1.

Output Format:
--------------
Print an integer, Number of distinct shapes formed by Blue Lights.


Sample Input-1:
---------------
4 5
1 1 0 1 1
1 1 0 0 1
0 0 0 0 0
1 1 0 0 0

Sample Output-1:
----------------
3


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

class Solution 
{    
    private static final int[] dRow = {-1, 1, 0, 0};
    private static final int[] dCol = {0, 0, -1, 1};
    
    private class DisjointSet 
	{
        private int[] parent;
        private int[] size;
        
        public DisjointSet(int V) 
		{
            parent = new int[V];
            size = new int[V];
            for (int i=0; i<V; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }
        
        public int find(int u) {
            return parent[u] == u ? u : (parent[u] = find(parent[u]));
        }
        
        public void union(int u, int v) 
		{
            int p1 = find(u);
            int p2 = find(v);
            if (p1 == p2) 
				return;

            if (size[p1] < size[p2]) 
			{
                parent[p1] = p2;
                size[p2] += size[p1];
            } else {
                parent[p2] = p1;
                size[p1] += size[p2];
            }
        }
    }
    
    public int numDistinctIslands(int[][] grid)
    {
        int nr = grid.length;
        int nc = grid[0].length;
        DisjointSet ds = new DisjointSet(nr * nc);
        
        for (int i=0; i<nr; i++)
        {
            for (int j=0; j<nc; j++)
            {
                if (grid[i][j] == 1)
                {
                for (int k=0; k<4; k++)
                    {
                    int row = i + dRow[k];
                    int col = j + dCol[k];
                    if (row >= 0 && row < nr && col >= 0 && col <nc && grid[row][col] == 1){  
                        ds.union(i*nc + j, row*nc + col);
                    }
                }
            }
            }
        }
        String []pattern = new String[nr*nc];
        for(int i=0; i < nr*nc; i++)
            pattern[i]= "";
        for(int i=0;i < nr; i++)
        {
            for(int j=0; j<nc; j++)
            {
            if(grid[i][j]==0)
                continue;
            int parent = ds.find(i*nc+j);
            pattern[parent] += String.valueOf(i*nc + j-parent);
            }
        }
        
        Set<String>tmp = new HashSet<>();
        for(int i=0;i<nr*nc; i++)
            {
            if(pattern[i].length()!=0)
                {
                tmp.add(pattern[i]);
                }
        }
        return tmp.size();
    }
    

}
public class DistinctIslands
{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		int grid[][]=new int[m][n];
		for(int i=0;i<m;i++)
			for(int j=0;j<n;j++)
				grid[i][j]=sc.nextInt();
				
		System.out.println(new Solution().numDistinctIslands(grid));
	}
}


/*
 * import java.util.*;

class Solution {
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Set<String> shapes = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    List<String> path = new ArrayList<>();
                    dfs(grid, visited, i, j, i, j, path);
                    shapes.add(String.join(",", path));
                }
            }
        }

        return shapes.size();
    }

    private void dfs(int[][] grid, boolean[][] visited, int i, int j, int baseRow, int baseCol, List<String> path) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || visited[i][j]) return;

        visited[i][j] = true;
        path.add((i - baseRow) + "_" + (j - baseCol));  // Relative position

        dfs(grid, visited, i - 1, j, baseRow, baseCol, path); // up
        dfs(grid, visited, i + 1, j, baseRow, baseCol, path); // down
        dfs(grid, visited, i, j - 1, baseRow, baseCol, path); // left
        dfs(grid, visited, i, j + 1, baseRow, baseCol, path); // right
    }
}

 */