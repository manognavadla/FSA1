import java.util.*;
class MazePath{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int m=sc.nextInt();
        int n= sc.nextInt();
        int[][] grid= new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                grid[i][j]=sc.nextInt();
            }
        }
        int x=sc.nextInt();
        int y=sc.nextInt();
        int x1=sc.nextInt();
        int y1=sc.nextInt();
        sol(grid,x,y,x1,y1);
        System.out.println(minc==Integer.MAX_VALUE?-1:minc);
    }
    static int minc=Integer.MAX_VALUE;
    static void sol(int[][]grid,int x,int y,int x1, int y1){
       boolean[][] vis= new boolean[grid.length][grid[0].length];
       dfs(grid,x,y,x1,y1,vis,0);
    
    }
    static final int[][] dirs={{1,0},{0,1},{-1,0},{0,-1}};
    static void dfs(int[][]grid, int x, int y, int x1,int y1, boolean[][] vis, int count){
        if(x==x1 && y==y1){
            minc=Math.min(count,minc);
            return;
        }
        vis[x][y]=true;
        for(int[] dir:dirs){
            int newX=x+dir[0];
            int newY=y+dir[1];
            if(newX>=0 && newY>=0 && newX<grid.length && newY<grid[0].length && !vis[newX][newY] && grid[newX][newY]==1){
                dfs(grid, newX, newY, x1, y1, vis, count+1);
            }
        }
        vis[x][y]=false;
    }
}