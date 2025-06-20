import java.util.*;
public class greedy {
    static int[] max(int n, int[] arr){
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=i+arr[i];
        }
        int min=0;
        
        return dp;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        // System.out.println(max(n, arr));
        int[] dp= max(n, arr);
        for(int i: dp) System.out.print(i);
    }
}
