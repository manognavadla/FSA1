package Day12;
/*
 * There is a bookstore owner that has a store open for n minutes. Every minute, some number of customers enter the store.
You are given an integer custay customers of length n where customers[i] is the number of the customer
that enters the store at the start of the ith minute and all those customers leave after the end of that minute.

On some minutes, the bookstore owner is grumpy. You are given a binary custay grumpy where grumpy[i] is 1
if the bookstore owner is grumpy during the ith minute, and is 0 otherwise.

When the bookstore owner is grumpy, the customers of that minute are not satisfied, 
otherwise, they are satisfied.

The bookstore owner knows a secret technique to keep themselves not grumpy for minutes consecutive minutes, 
but can only use it once.

Return the maximum number of customers that can be satisfied throughout the day.
 
Sample Input-1:
---------------
8
1 0 1 2 1 1 7 5
0 1 0 1 0 1 0 1
3

Sample Output-1: 
----------------
16

Explanation:
------------
The bookstore owner keeps themselves not grumpy for the last 3 minutes. 
The maximum number of customers that can be satisfied = 1 + 1 + 1 + 1 + 7 + 5 = 16.

Sample Input-2:
---------------
1
1
0
1

Sample Output-2:
----------------
1
 

Constraints:

n == customers.length == grumpy.length
1 <= minutes <= n <= 2 * 104
0 <= customers[i] <= 1000
grumpy[i] is either 0 or 1.
 */
import java.util.*;
public class BookStore{
    public static int helper(int n, int[] arr, int[] arr2, int k){
        int sum = 0;
        for(int i=0;i<n;i++){
            if(arr2[i] == 0)sum += arr[i];
        }
        
        int tsum = 0;
        for(int i=0;i<k;i++){
            if(arr2[i] == 1){
                tsum += arr[i];
            }
        }
        int maxSum = tsum;
        int fp = 0;
        for(int i=k;i<n;i++){
            if(arr2[i-k] == 1){
                tsum -= arr[i-k];
            }
            if(arr2[i] == 1){
                tsum += arr[i];
            }
            maxSum = Math.max(maxSum, tsum);
        }
        return maxSum + sum;
    }
    public static void main(String[] arhs){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for(int i=0;i<n;i++)arr1[i] = sc.nextInt();
        for(int i=0;i<n;i++)arr2[i] = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(helper(n,arr1,arr2,k));
}
}
