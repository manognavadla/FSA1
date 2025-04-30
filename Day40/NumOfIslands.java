import java.util.*;
//public class NumOfIslands {
public class NumOfIslands {
    private int[] sz;
    private int[] parent;
    private int rows, cols;
    static int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int find(int p) {
        if(parent[p] != p){
            // p = find(parent[p]);
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);

        if (rootP == rootQ) return;

        if (sz[rootP] < sz[rootQ]) {
            sz[rootQ] += sz[rootP];
            parent[rootP] = parent[rootQ];
        }
        else {
            sz[rootP] += sz[rootQ];
            parent[rootQ] = parent[rootP];
        }
    }

    public int numIslands(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        sz = new int[row*col];
        parent = new int[row*col];

        for(int i = 0; i < row*col; i++) {
            parent[i] = i;
            sz[i] = 1;
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                int index = i * col + j;
                if(grid[i][j] == 1) {
                    for(int[] dir : dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if(x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == 1) {
                            int newindex = x * col + y;
                            union(index, newindex);
                        }
                    }
                }
            }
        }
        Set<Integer> hs = new HashSet<>();
        for(int i = 0; i < row*col; i++) {
            if(grid[i/col][i%col] == 1) {
                hs.add(find(i));
            }
        }
        return hs.size();
    }

    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int row = s.nextInt();
        int col = s.nextInt();
        int arr[][] = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = s.nextInt();
            }
        }
//        System.out.println(new NumOfIslands().numIslands(arr));
        System.out.println(new NumOfIslands().numIslands(arr));

    }
}