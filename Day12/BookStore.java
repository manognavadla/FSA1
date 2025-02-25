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
public class BookStore {
    static int maxsub(int[] cust, int n, int g){
        int maxsum=Integer.MIN_VALUE, index=0;
        int sum=0,ind=0;
        for(int i=0;i<g;i++){
            sum+=cust[i];
        }      
        if(sum>maxsum){
            maxsum=sum;
            index=ind;
        }
        for(int i=g;i<n;i++){
            ind++;
            sum-=cust[i-g]+cust[i];
            if(maxsum<sum){
                maxsum=sum;
                index=ind;
            }
        }
        return index;
    }
    static int sat(int n, int[] cust, int[] grump, int g){
        int sum=0;
        int w=maxsub(cust, n, g);
        int i;
        for( i=0;i<w;i++){
            if(grump[i]==0) sum+=cust[i];
        }
        for( i=w;i<w+g;i++) sum+=cust[i];
        if(i<n-1){
            while(i<n){
                if(grump[i]==0) sum+=cust[i];
                i++;
            }
        }

        return sum;
    }
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int[] cust= new int[n];
        int[] grump= new int[n];
        for(int i=0;i<n;i++) cust[i]=sc.nextInt();
        for(int i=0;i<n;i++) grump[i]=sc.nextInt();
        int g=sc.nextInt();
        System.out.println(sat(n,cust,grump,g));
    }
}
