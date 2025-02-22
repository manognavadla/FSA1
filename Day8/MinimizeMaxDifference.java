package Day8;
/*
 * You are given three sorted integer arrays A[], B[], and C[]. 

Your task is to find one element from each array (A[i], B[j], and C[k]) 
such that the following expression is minimized:
    
   x =  max(∣A[i]−B[j]∣,∣B[j]−C[k]∣,∣C[k]−A[i]∣)
where |x| denotes the absolute value of x.

You need to return the three selected elements A[i], B[j], and C[k] that result in the minimum possible value of the above expression.

Input Format:
-------------
Line-1: An integer n, the size of array A, followed by n space-separated integers representing array A.
Line-2: An integer m, the size of array B, followed by m space-separated integers representing array B.
Line-3: An integer p, the size of array C, followed by p space-separated integers representing array C.

Output Format:
--------------
Line-1: Print three space-separated integers A[i] B[j] C[k] that minimize the given expression.


Sample Input-1:
---------------
3
1 4 10
3
2 15 20
2
10 12

Sample Output-1:
----------------
10 15 10

Sample Input-2:
---------------
24 22 23

Sample Output-1:
----------------
10 15 10

Sample Input-2:
---------------
3
0 0 0
1

Sample Output-2:
----------------
0
 */
import java.util.*;
class MinimizeMaxDifference{
    public static int[] minmax(int n1, int[] arr1, int n2, int[] arr2, int n3, int[] arr3){
        int min=Integer.MAX_VALUE;
        int[] res=new int[3];
        int i=0,j=0,k=0;
        while(i<n1 && j<n2 && k<n3){
            int sum= Math.max(Math.abs(arr1[i]-arr2[j]),Math.max(Math.abs(arr2[j]-arr3[k]),Math.abs(arr3[k]-arr1[i])));
            if(sum<min){
                min=sum;
                res[0]= arr1[i];
                res[1]=arr2[j];
                res[2]=arr3[k];
            }
            if(arr1[i]<=arr2[j] && arr1[i]<=arr3[k]) i++;
            else if(arr2[j]<=arr1[i] && arr2[j]<=arr3[k] ) j++;
            else k++;
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n1= sc.nextInt();
        int arr1[]= new int[n1];
        for(int i=0;i<n1;i++) arr1[i]=sc.nextInt();
        int n2= sc.nextInt();
        int arr2[]= new int [n2];
        for(int i=0;i<n2;i++) arr2[i]=sc.nextInt();
        int n3=sc.nextInt();
        int[] arr3= new int[n3];
        for(int i=0;i<n3;i++) arr3[i]=sc.nextInt();
        System.out.print(Arrays.toString(minmax(n1,arr1, n2, arr2, n3, arr3)));
        
    }
}