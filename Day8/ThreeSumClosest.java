package Day8;
/*
 You are given an integer array nums of length n and an integer target. 
Your task is to find three integers in nums such that their sum is closest to the given target.

Return the sum of these three integers.

You may assume that each input would have exactly one solution.

Input Format:
-------------
Line-1: An integer n, the size of the array.
Line-2: n space-separated integers representing the elements of the array nums.
Line-3: A single integer target.

Output Format:
--------------
Line-1: Print a single integer, representing the sum of three integers closest to the target.

Sample Input-1:
---------------
4
-1 2 1 -4
1

Sample Output-1:
----------------
2

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
public class ThreeSumClosest {
    public static int threesum(int n, int[] arr, int k){
        Arrays.sort(arr);
        int mindiff=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<n-2;i++){
            int l=i+1, r=n-1;
            while(l<r){
                int s=arr[i]+arr[l]+arr[r];
                int diff=Math.abs(k-s);
                if(diff<mindiff){
                    diff=mindiff;
                    sum=s;
                }if(s<k) l++;
                else if(s>k) r--;
                else return k;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        int k=sc.nextInt();
        System.out.println(threesum(n, arr, k));
    }
}
