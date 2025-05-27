/*
 * You are given a string S representing a positive integer and an integer k. Your task is to find the smallest possible number that can be formed by performing at most k swaps between any two digits of the string.
If k == 0, return the original number.
If the number is already the smallest possible permutation, return it as-is.
If the input is null or empty, return it unchanged.

A swap operation means exchanging the positions of any two digits (not necessarily adjacent). Each swap counts as one operation. The goal is to minimize the number.

Input Format:
-----------
A string S of digits (1 ≤ S.length ≤ 10)
An integer k (0 ≤ k ≤ 10) representing the number of allowed swaps.

Output Format:
------------
A string representing the smallest number possible after performing at most k swaps.

Constraints:
--------------
1 ≤ length(S) ≤ 10
0 ≤ k ≤ 10
Digits are in the range '0' to '9'
No leading zeros in input unless the number is exactly "0"
Each swap counts as 1 operation, regardless of position

Sample Input-1:
------------
934651
2

Sample Output-1:
----------------
134569

Sample Input-2:
-------------
11111
3
Sample Output-2:
--------------
11111


 */
import java.util.*;
class kSwaps{
    static String min;
    static void swap(char[] arr, int i, int j){
        char e=arr[i];
        arr[i]=arr[j];
        arr[j]=e;
    }
    static String mini(String s, int k){
        char[] arr= s.toCharArray();
        min= new String(s);
        util(0,arr,k);
    
        return min;
    }
    static void util(int i, char[] arr, int k){
        if(k==0 || arr.length==i){
            String c=new String(arr);
            if(c.compareTo(min)<0) min= c;
            return;
        }
        char m=arr[i];int y=i;
        for(int st=i+1;st<arr.length;st++){
            if(arr[st]<m){ m=arr[st];y=st;}
        }
        if(m==arr[i]) util(i+1,arr,k);
        else{
            swap(arr,i,y);
            util(i+1,arr,k-1);
            swap(arr,i,y);
        }
        
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        String s= sc.next();
        int k=sc.nextInt();
        System.out.print(mini(s,k));
    }
}