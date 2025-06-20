/*
 * Deep in the archives of the ancient Temple of Equilibria, 
a treasure hunter discovers a long corridor of numbered tiles. 
Each tile bears a mysterious integer—some positive, some negative. 
Legend says that stepping on a sequence of tiles whose sum is exactly zero will unlock the hidden vault door. 
However, the hunter’s time is short: they must find the longest such contiguous stretch of tiles to trigger the mechanism before the temple collapses.

Input Format:
-------------
Line 1: A single integer N, the number of tiles.
Line 2: N space-separated integers tiles[0] tiles[1] … tiles[N-1].

Output Format:
---------------
A single integer denoting the length of the longest zero-sum tiles subarray.

Constraints
-----------
-> 1≤N≤10^5
-> −10^9≤tiles[i]≤10^9
 
Sample Input-1:
---------------
8
14 -1 1 -6 1 5 12 17

Sample Output-1:
----------------
5

Explanation: The longest sub-array with elements summing upto 0 is [-1, 1, -6, 1 5]

Sample Input-2:
---------------
3
1 5 10

Sample Output-2:
----------------
0

Explanation: There is no subarray with sum 0
 */

import java.util.*;
public class LargestZeroSum {
    static int path(int n, int[] arr){
       Map<Integer,Integer> hm= new HashMap<>();
       int sum=0;
       int max=0;
       hm.put(0,-1);
       for(int i=0;i<n;i++){
            sum+=arr[i];
            if(hm.containsKey(sum)){
                max=Math.max(max, i-hm.get(sum));
            }else{
                hm.put(sum, i);
            }
            
       }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr= new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        System.out.println(path(n, arr));
    }
}
