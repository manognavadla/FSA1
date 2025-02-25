/*
 * Given an integer array nums sorted in non-decreasing order, 
return an array of the squares of each number sorted in non-decreasing order.

Input Format:
-------------
Line-1: An integer N
Line-2: N space seperated integers

Output Format:
--------------
Line-1: A list of integers

Sample Input-1:
---------------
5
-4 -1 0 3 10

Sample Output-1: 
----------------
[0, 1, 9, 16, 100]


 */
import java.util.*;
class squares{
    public static List<Integer> square(int n, int[] arr){
        List<Integer> res= new ArrayList<>();
        int l=0,r=n-1;

        while(l<=r){
            if(Math.abs(arr[l])>Math.abs(arr[r])){
                res.add((int)Math.pow(arr[l],2));
                l++;
            }
            else if(Math.abs(arr[l])<Math.abs(arr[r])){
                res.add((int)Math.pow(arr[r],2));
                r--;
            }
            else{
                res.add((int)Math.pow(arr[l],2));
                res.add((int)Math.pow(arr[r],2));
                l++;r--;
            }
        }
     Collections.reverse(res);
     return res;
        
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        System.out.println(square(n,arr));
    }
}
